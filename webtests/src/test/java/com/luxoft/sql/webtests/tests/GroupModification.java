package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModification extends BaseTest {

    @Test
    public void test(){
        login("admin", "secret");
        findFirsContact();
        initGroupModification();
        fillContact(new GroupData("Петр", "AAa", "Семенович", "Семеновская 18/28"));
        driver.findElement(By.name("update")).click();
        goToMenu("home");
        Assert.assertEquals(findFirsContact(), "AA Иван Семеновская 18/28");

    }

    private void initGroupModification(){
        driver.findElement(By.linkText("Edit")).click();
    }


}
