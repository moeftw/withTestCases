package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a")
    WebElement PIM;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span")
    WebElement selectAllEmployees;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")
    WebElement deleteSelected;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmDeleteRecords;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement addEmployeeBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement pimButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    WebElement firstNameLastName;


    //methods
    public void clickOnPIM() {
        clickOn(PIM);
    }

    public void SelectAll() {
        clickOn(selectAllEmployees);
    }

    public void clickOnDelete() {
        clickOn(deleteSelected);
        waitFor(5);
    }

    public boolean confirmDelete() {
        waitFor(3);
        clickOn(confirmDeleteRecords);
        return true;
    }


    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void clickSaveButton() {
        saveButton.click();
        waitFor(20);
    }

    public void clickAddEmployeeButton() {
        pimButton.click();
        addEmployeeBtn.click();
    }

    public String showsFirstAndLastName() {

        return firstNameLastName.getText();

    }

}
