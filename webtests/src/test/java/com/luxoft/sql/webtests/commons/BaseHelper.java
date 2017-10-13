package com.luxoft.sql.webtests.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseHelper {

    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
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

}
