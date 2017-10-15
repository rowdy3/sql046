package com.luxoft.sql.webtests.commons;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    public final Applicaton app = new Applicaton();

    @BeforeClass
    public void start(){
        app.init();
    }

    @AfterTest
    public void close(){
        app.stop();
    }


}
