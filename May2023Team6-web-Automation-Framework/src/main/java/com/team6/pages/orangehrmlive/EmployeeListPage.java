package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public EmployeeListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        {


        }
    }
}