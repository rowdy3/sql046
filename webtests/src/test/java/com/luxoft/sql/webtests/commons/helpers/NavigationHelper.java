package com.luxoft.sql.webtests.commons.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver){
        super(driver);
    }

    public void goToMenu (String name){
            click(By.linkText(name));
            waitLoading();
    }
}
