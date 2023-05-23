package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement mainHeader;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")
    WebElement sideBarMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement adminText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/button/svg")
    WebElement assignLeaveBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement userNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    WebElement EmployeeNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
    WebElement accountButton;
//
//     @FindBy(xpath = "")
//    WebElement name;
//
//     @FindBy(xpath = "")
//    WebElement name;
//
//     @FindBy(xpath = "")
//    WebElement name;
//
//     @FindBy(xpath = "")
//    WebElement name;


    //reusable methods
    public String getHeaderText() {
        waitFor(5000);
        String text = getElementText(mainHeader);
        log.info("user logged in success");
        return text;
    }

    public void clickOnSidebarMenuIcon() {
        waitFor(10000);
        clickOn(sideBarMenu);
        log.info("click on sideBar menu success");
    }

    public void clickOnAssignLeaveBtn() {
        waitFor(10000);
        clickOn(assignLeaveBtn);
        log.info("click on sideBar menu success");
    }

    public void hoverOverOnAndClickLogoutLink() {
        waitFor(5000);
        hoverOverAndClickOn(logoutLink);
        log.info("click on logout link success");
    }



    public boolean isMenuOptionsVisible() {
        waitFor(5000);
        return isVisible(adminText);
    }

    public boolean isSidebarMenuButtonClickable() {
        try {
            sideBarMenu.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnLogoutButton() {
        accountButton.click();
        waitFor(5);
        logoutLink.click();
    }


    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }
}