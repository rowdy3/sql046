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
        app.getContactHelper().createContact (new GroupData("Иван", "Петров", null, null), true);
        app.getNavigationHelper().goToMenu("home");
       Assert.assertEquals(app.getContactHelper().findFirsContact(), "AA Иван Семеновская 18/28");
    }

}
