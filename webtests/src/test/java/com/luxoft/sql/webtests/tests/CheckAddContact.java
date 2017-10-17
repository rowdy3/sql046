package com.luxoft.sql.webtests.tests;


import com.luxoft.sql.webtests.commons.BaseTest;
import com.luxoft.sql.webtests.commons.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CheckAddContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        int countContactBefore = app.getContactHelper().getContactCount();
        app.getNavigationHelper().goToMenu("add new");
        app.getContactHelper().createContact (new GroupData("Иван", "AA", null, "Семеновская 18/28"), true);
        app.getNavigationHelper().goToMenu("home");
        int countContactAfter= app.getContactHelper().getContactCount();
        Assert.assertEquals(countContactAfter, countContactBefore + 1);
        Assert.assertTrue(app.getContactHelper().findContactData("AA Иван Семеновская 18/28"), "Клиент AA Иван Семеновская 18/28 находится в списке?");
    }

}
