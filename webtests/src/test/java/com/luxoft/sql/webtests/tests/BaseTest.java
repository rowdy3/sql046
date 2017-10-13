package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.Applicaton;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    protected final Applicaton app = new Applicaton();

    @BeforeClass
    public void start(){
        app.init();
    }

    @AfterTest
    public void close(){
        app.stop();
    }


}
