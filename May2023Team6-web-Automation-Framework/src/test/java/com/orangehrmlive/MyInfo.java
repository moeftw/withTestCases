package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.*;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Properties;

public class MyInfo extends CommonAPI {
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
    public void changingPersonalInfo() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());
        MyInfoPage mI = new MyInfoPage(getDriver());
        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        mI.clickOnMyInfo();
        mI.enterFirstName("Domina");
        mI.enterLastName("Burndead");
        mI.clickOnSave();
        Assert.assertEquals(mI.firstNameLastName(), "Domina Burndead");
    }

    @Test
    public void verifyAccountName() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());
        MyInfoPage mI = new MyInfoPage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        mI.clickOnMyInfo();
        // Verifying that Account Name matches.
        Assert.assertEquals(mI.accountName(), mI.firstNameLastName());
    }

}