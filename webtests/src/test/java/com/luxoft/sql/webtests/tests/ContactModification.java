package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.BaseTest;
import com.luxoft.sql.webtests.commons.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModification extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        if(app.getContactHelper().contactListExist() == false){
            app.getNavigationHelper().goToMenu("add new");
            app.getContactHelper().createContact(new GroupData("Петр", "A", "Семенович", "Семеновская 18/28"), true);
            app.getNavigationHelper().goToMenu("home");
        }
        app.getContactHelper().findFistGroup();
        app.getContactHelper().initGroupModification();
        app.getContactHelper().fillContact(new GroupData("Петр", "Aa", "Семенович", "Семеновская 18/28"), false);
        app.getContactHelper().doneWorkWithContact("update");
        app.getNavigationHelper().goToMenu("home");
        Assert.assertEquals(app.getContactHelper().findFirsContact(), "Aa Петр Семеновская 18/28");

    }




}
