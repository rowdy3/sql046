package com.luxoft.sql.webtests.commons.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseHelper {

    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void fillInTheField(By locator, String text) {
        if(text != null){
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! existingText.equals(text)){
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
    protected void waitLoading() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void alertWindow() {
        driver.switchTo().alert().accept();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;

        }
    }

}
