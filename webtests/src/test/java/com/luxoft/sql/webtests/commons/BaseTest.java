package com.luxoft.sql.webtests.commons;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.BrowserType;


public class BaseTest {

    public final Applicaton app = new Applicaton(BrowserType.CHROME);

    @BeforeClass
    public void start(){
        app.init();
    }

    @AfterTest
    public void close(){
        app.stop();
    }


}
