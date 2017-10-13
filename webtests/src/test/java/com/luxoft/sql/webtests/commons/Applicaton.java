package com.luxoft.sql.webtests.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Applicaton {

    private final String loginPage = "http://localhost:8080/addressbook/index.php";
    ContactHelper contactHelper;
    LoginSession loginSession;
    NavigationHelper navigationHelper;
    WebDriver driver;


    public void init() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        contactHelper = new ContactHelper(driver);
        loginSession = new LoginSession(driver);
        navigationHelper = new NavigationHelper(driver);
        driver.get(loginPage);
    }

    public void stop() {
       driver.close();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public LoginSession getLoginSession() {
        return loginSession;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
