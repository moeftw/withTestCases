package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.*;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Properties;

public class PimTest extends CommonAPI {
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
    public void verifyAddEmployee() {
        LoginPage lp = new LoginPage(getDriver());

        PimPage PIM = new PimPage(getDriver());
        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();

        PIM.clickAddEmployeeButton();
        PIM.enterFirstName("Mohammad");
        PIM.enterLastName("Taseen");
        PIM.clickSaveButton();
        Assert.assertEquals(PIM.showsFirstAndLastName(), "Mohammad Taseen");
    }

    @Test
    public void deleteEmployeeRecords() {
        LoginPage lp = new LoginPage(getDriver());
        PimPage PIM = new PimPage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        PIM.clickOnPIM();
        PIM.SelectAll();
        PIM.clickOnDelete();

        Assert.assertTrue(PIM.confirmDelete());
    }

}

