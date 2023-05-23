package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Properties;

public class LoginTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    @Test
    public void validateLogin() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());
        // Verify login page
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Perform login with valid credentials
        lp.enterUsername(validUsername);
        lp.enterPassword(validPassword);
        lp.clickOnLoginBtn();

    }


    @Test
    public void verifyLoginPageElements() {
        LoginPage lp = new LoginPage(getDriver());

        Assert.assertTrue(lp.usernameField.isDisplayed());
        Assert.assertTrue(lp.passwordField.isDisplayed());
        Assert.assertTrue(lp.loginBtn.isDisplayed());
    }


    @Test
    public void validateSidebarMenuButton() {
        HomePage hp = new HomePage(getDriver());
        LoginPage lp = new LoginPage(getDriver());
        // login
        lp.enterUsername(validUsername);
        lp.enterPassword(validPassword);
        lp.clickOnLoginBtn();

        // Verify that the sidebar menu button is clickable
        Assert.assertTrue(hp.isSidebarMenuButtonClickable());
    }

    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("InvalidPassword");
        loginPage.clickOnLoginBtn();

      //  Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }



}