package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.BaseTest;
import org.testng.annotations.Test;


public class CheckDeleteFirstContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        //String deleteContact = app.getContactHelper().findContactByPositoin(1);
        String deleteContact = "dfdfdfd";
        app.getContactHelper().deleteFirstContact(1);
        app.getNavigationHelper().goToMenu("home");
        if (app.getContactHelper().findContactByPositoin(1) == deleteContact) {
           throw new IllegalArgumentException("Контакт " + deleteContact + " не удален");
        }
    }


}
