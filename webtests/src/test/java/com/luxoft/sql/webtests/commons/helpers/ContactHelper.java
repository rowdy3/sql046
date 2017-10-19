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
        click(By.xpath(firstContact + "//td[1]"));
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
        List<WebElement> webElementListContact = webElementList.subList(1,webElementList.size());
        int x = 0;
        for (WebElement rowElement: webElementListContact) {
            List<WebElement> cellsLastName = rowElement.findElements(By.xpath("//td[2]"));
            List<WebElement> cellsFirstName = rowElement.findElements(By.xpath("//td[3]"));
            String lastName = cellsLastName.get(x).getText();
            String firstName = cellsFirstName.get(x).getText();
            GroupData listElement = new GroupData(firstName, lastName,null, null);
            contactLastNameList.add(listElement);
            x++;
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
