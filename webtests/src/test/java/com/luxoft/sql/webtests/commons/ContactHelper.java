package com.luxoft.sql.webtests.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper{

    private String firstContact = "//*[@id = 'maintable']//tr[2]";

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void deleteFirstContact(){
        click(By.xpath(firstContact + "//td[2]"));
        click(By.cssSelector("input[type='button'][value = 'Delete']"));
        alertWindow();
    }

    public void findFistGroup(){
        driver.findElement(By.name("selected[]"));
    }

    public String findFirsContact(){
        String itemXPath = String.format(firstContact);
        return driver.findElement(By.xpath(itemXPath)).getText();
    }

    public void fillContact(GroupData groupData){
        type(By.name("firstname"), groupData.getName());
        type(By.name("lastname"), groupData.getLastName());
        type(By.name("middlename"), groupData.getMiddleName());
        type(By.name("address"), groupData.getAddress());
    }

    public void doneWorkWithContact(String buttonName){
        click(By.name(buttonName));
    }

    public void initGroupModification(){
        click(By.cssSelector("a [title='Edit']"));
    }

}
