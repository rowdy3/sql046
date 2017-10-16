package com.luxoft.sql.webtests.commons;

import com.luxoft.sql.webtests.commons.helpers.ContactHelper;
import com.luxoft.sql.webtests.commons.helpers.LoginSession;
import com.luxoft.sql.webtests.commons.helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


public class Applicaton {

    private final String loginPage = "http://localhost:8080/addressbook/index.php";
    ContactHelper contactHelper;
    LoginSession loginSession;
    NavigationHelper navigationHelper;
    WebDriver driver;
    String browser;



    public Applicaton(String browser){
        this.browser = browser;
    }


    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }else if (browser.equals(BrowserType.IE)){
            driver = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.EDGE)){
            driver = new EdgeDriver();
        }
        //System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");

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
