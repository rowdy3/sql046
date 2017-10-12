package com.luxoft.sql.webtests.tests;

import com.luxoft.sql.webtests.commons.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public final String loginPage = "http://localhost:8080/addressbook/index.php";
    public String firstContact = "//*[@id = 'maintable']//tr[2]";
    WebDriver driver;

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

    public void deleteFirstContact(){
        driver.findElement(By.xpath(firstContact + "//td[2]")).click();
        driver.findElement(By.cssSelector("input[type='button'][value = 'Delete']")).click();
        driver.switchTo().alert().accept();
    }

    //TODO придумать как нажать на редактирование при таком поиске контакта

    public String findFirsContact(){
        String itemXPath = String.format(firstContact);
        return driver.findElement(By.xpath(itemXPath)).getText();
    }

    public void fillContact(GroupData groupData){
        driver.findElement(By.name("firstname")).sendKeys(groupData.getName());
        driver.findElement(By.name("lastname")).sendKeys(groupData.getLastName());
        driver.findElement(By.name("middlename")).sendKeys(groupData.getMiddleName());
        driver.findElement(By.name("address")).sendKeys(groupData.getAddress());
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
