package com.luxoft.sql.webtests.tests;


import com.luxoft.sql.webtests.commons.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckAddContact extends BaseTest{

    @Test
    public void test(){
        login("admin", "secret");
        goToMenu("add new");
        fillContact(new GroupData("Иван", "AA", "Семенович", "Семеновская 18/28"));
        driver.findElement(By.name("submit")).click();
        goToMenu("home");
       Assert.assertEquals(findFirsContact(), "AA Иван Семеновская 18/28");
    }

}
