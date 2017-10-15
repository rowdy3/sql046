package com.luxoft.sql.webtests.commons.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSession extends BaseHelper {

    public LoginSession(WebDriver driver){
        super(driver);
    }

    public void login(String login, String password){
        fillInTheField(By.name("user"), login);
        fillInTheField(By.name("pass"), password);
        click(By.cssSelector("input[type='submit']"));
    }
}
