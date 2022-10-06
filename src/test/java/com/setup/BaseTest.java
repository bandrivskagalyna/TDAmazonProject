package com.setup;

import configuration.BaseMethod;
import configuration.DeviceFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObject.PageObjectInitializer;

public class BaseTest extends BaseMethod {

    protected WebDriver driver;
    protected PageObjectInitializer PO;

    @BeforeClass
    @Parameters(value = {"Device"})
    public void initClass(String device, ITestContext context) throws Exception {
        driver = new DeviceFactory().createDriver(device);
        PO = new PageObjectInitializer(driver);
        setDriverAndWait(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
