package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.BaseTest;
import com.luxoft.sql.webtests.commons.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class CheckDeleteFirstContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        List <GroupData> before = app.getContactHelper().findContactlist();
        app.getContactHelper().deleteFirstContact();
        app.getNavigationHelper().goToMenu("home");
        List<GroupData> after = app.getContactHelper().findContactlist();
        before.remove(0);
        Comparator<? super GroupData> lastName = (o1, o2) -> o1.getLastName().compareTo(o2.getLastName());
        before.sort(lastName);
        after.sort(lastName);
        Assert.assertEquals(after, before);
    }


}
