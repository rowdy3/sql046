package com.luxoft.sql.webtests.commons.helpers;

import com.luxoft.sql.webtests.commons.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

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

    public boolean findContactData(String contactFullName){
        List<String> contactList = new ArrayList<>();
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@id = 'maintable']//tr"));
        for (WebElement element: webElementList) {
            contactList.add(element.getText());
        }
        return contactList.contains(contactFullName);
    }

    public List<GroupData> findContactlist(){
        List<GroupData> contactLastNameList = new ArrayList<>();
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@id = 'maintable']//tr"));
        for (WebElement rowElement: webElementList) {
            System.out.println(rowElement.getText());
            String lastName = rowElement.findElement(By.xpath("//td[2]")).getText();
            String firstName = rowElement.findElement(By.xpath("//td[3]")).getText();
            GroupData listElement = new GroupData(firstName, lastName,null, null);
            contactLastNameList.add(listElement);
        }
        return contactLastNameList;
    }

    public boolean contactListExist(){
        return isElementPresent(By.cssSelector("a [title='Edit']"));
    }

    public void createContact (GroupData groupData){
        fillContact(groupData);
        doneWorkWithContact("submit");
    }


    public void fillContact(GroupData groupData){
       /* if(creation){
                Select group = new Select(driver.findElement(By.name("new_group")));
                group.selectByIndex(1);
            } else Assert.assertFalse(isElementPresent(By.name("new_group")));*/

            fillInTheField(By.name("firstname"), groupData.getName());
            fillInTheField(By.name("lastname"), groupData.getLastName());
            fillInTheField(By.name("middlename"), groupData.getMiddleName());
            fillInTheField(By.name("address"), groupData.getAddress());
    }

    public void doneWorkWithContact(String buttonName){
        click(By.name(buttonName));
    }

    public void initGroupModification(){
        click(By.cssSelector("a [title='Edit']"));
    }

    public int getContactCount() {
        return driver.findElements(By.cssSelector("a [title='Edit']")).size();
    }
}
