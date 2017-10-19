package com.luxoft.sql.webtests.tests;


import com.luxoft.sql.webtests.commons.BaseTest;
import com.luxoft.sql.webtests.commons.GroupData;
import com.sun.deploy.association.AssociationAlreadyRegisteredException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class CheckAddContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        List<GroupData> before = app.getContactHelper().findContactlist();
        app.getNavigationHelper().goToMenu("add new");
        GroupData contact = new GroupData("Иван", "AA", null, "Семеновская 18/28");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToMenu("home");
        List<GroupData> after = app.getContactHelper().findContactlist();
        before.add(contact);
        Comparator<? super GroupData> lastName = (o1, o2) -> o1.getLastName().compareTo(o2.getLastName());
        before.sort(lastName);
        after.sort(lastName);
        Assert.assertEquals(after, before);
    }

}
