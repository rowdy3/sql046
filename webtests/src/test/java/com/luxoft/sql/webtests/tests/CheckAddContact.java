package com.luxoft.sql.webtests.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class CheckAddContact {
    public final String loginPage = "http://localhost:8080/addressbook/index.php";
    WebDriver driver;

    @Test
    public void test(){
        login("admin", "secret");

        goToMenu("add new");
        driver.findElement(By.name("firstname")).sendKeys("Иван");
        driver.findElement(By.name("middlename")).sendKeys("Анатольевич");
        driver.findElement(By.name("lastname")).sendKeys("Петров");
        driver.findElement(By.name("address")).sendKeys("Маркса 18/28");
        driver.findElement(By.name("submit")).click();

        goToMenu("home");
       Assert.assertEquals(findContact("last()"), "Петров Иван Маркса 18/28");
    }

    public void login(String login, String password){
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(login);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void goToMenu (String name){
        driver.findElement(By.linkText(name)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String findContact(String contactNumder){
        String itemXPath = String.format("//*[@id = 'maintable']//tr[%s]", contactNumder);
        return driver.findElement(By.xpath(itemXPath)).getText();
    }

    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(loginPage);
    }

    @AfterTest
    public void close(){
        driver.close();
    }

}
