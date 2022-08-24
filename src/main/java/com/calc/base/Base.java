package com.calc.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Base {

    public Base(){
        // we do this to build elements of every page we will create
        // when I extend this class from page and test case take object from page
        // this constructor will done and i can build elements
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected static AndroidDriver  <AndroidElement> driver;
    protected FileInputStream inputStream;
    protected  File propFile;
    protected  Properties prop;

    @Parameters({"deviceName","platformName","platformVersion"})
    @BeforeClass
    public void beforeClass(String deviceName , String platformName , String platformVersion) throws IOException {
        propFile = new File("src\\main\\resources\\configs\\config.properties");
        inputStream = new FileInputStream(propFile);
        prop = new Properties();
        prop.load(inputStream);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME , platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION , platformVersion);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME , prop.getProperty("automationName"));

        driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("appiumUrl")), caps);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
