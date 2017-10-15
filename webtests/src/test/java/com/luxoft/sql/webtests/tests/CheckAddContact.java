package com.luxoft.sql.webtests.tests;


import com.luxoft.sql.webtests.commons.BaseTest;
import com.luxoft.sql.webtests.commons.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckAddContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        app.getNavigationHelper().goToMenu("add new");
        app.getContactHelper().fillContact(new GroupData("Иван", "A", "Семенович", "Семеновская 18/28"));
        app.getContactHelper().doneWorkWithContact("submit");
        app.getNavigationHelper().goToMenu("home");
       Assert.assertEquals(app.getContactHelper().findFirsContact(), "AA Иван Семеновская 18/28");
    }

}
