package com.luxoft.sql.webtests.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSession extends BaseHelper{

    public LoginSession(WebDriver driver){
        super(driver);
    }

    public void login(String login, String password){
        type(By.name("user"), login);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type='submit']"));
    }
}
