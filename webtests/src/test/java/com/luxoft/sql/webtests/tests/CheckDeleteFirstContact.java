package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.BaseTest;
import org.testng.annotations.Test;


public class CheckDeleteFirstContact extends BaseTest {

    @Test
    public void test(){
        app.getLoginSession().login("admin", "secret");
        //String deleteContact = app.getContactHelper().findContactlist(1);
        String deleteContact = "dfdfdfd";
        app.getContactHelper().deleteFirstContact();
        app.getNavigationHelper().goToMenu("home");
        /*if (app.getContactHelper().findContactlist() == deleteContact) {
           throw new IllegalArgumentException("Контакт " + deleteContact + " не удален");
        }*/
    }


}
