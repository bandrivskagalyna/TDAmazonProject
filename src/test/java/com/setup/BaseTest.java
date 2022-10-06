package com.setup;

import configuration.BaseMethod;
import configuration.DeviceFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObject.PageObjectInitializer;

public class BaseTest extends BaseMethod {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected PageObjectInitializer PO;


    @BeforeClass
    public void initClass() throws Exception {
        driver = DeviceFactory.createDriver();
        PO = new PageObjectInitializer(driver);
        setDriverAndWait(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
