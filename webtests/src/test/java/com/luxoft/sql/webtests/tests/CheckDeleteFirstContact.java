package com.luxoft.sql.webtests.tests;

import org.testng.annotations.Test;


public class CheckDeleteFirstContact extends BaseTest{

    @Test
    public void test(){
        login("admin", "secret");
        String deleteContact = findFirsContact();
        deleteFirstContact();
        goToMenu("home");
        if (findFirsContact() == deleteContact) {
           throw new IllegalArgumentException("Контакт " + deleteContact + " не удален");
        }
    }


}
