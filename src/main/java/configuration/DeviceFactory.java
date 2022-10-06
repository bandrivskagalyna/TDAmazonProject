package configuration;

import configuration.data.DeviceProperty;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DeviceFactory {

    @Step("Create driver for device")
    public WebDriver createDriver(String device) throws Exception {
        WebDriver driver;

        DeviceProperty deviceProperty = new PropertyLoader().loadProperties(device);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (deviceProperty.getPlatformName()) {
            case "Android":
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/Apps/Amazon/");
                File app = new File(appDir, "AmazonShopping.apk");

                capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
                capabilities.setCapability("deviceName", deviceProperty.getDeviceName());
                capabilities.setCapability("platformName", deviceProperty.getPlatformName());
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", deviceProperty.getAppPackage());
                capabilities.setCapability("appActivity", deviceProperty.getAppActivity());
                capabilities.setCapability("unicodeKeyboard", deviceProperty.getUnicodeKeyboard());
                capabilities.setCapability("resetKeyboard", deviceProperty.getResetKeyboard());

                driver = new AndroidDriver(new URL(buildAppiumUrl()), capabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
                break;

            case "iOS":
                //TODO set information related to iOS driver

                driver = new IOSDriver(capabilities);
                break;


            default:
                throw new NotFoundException("Platform Not Found. Please Provide a Valid Device information");
        }

        return driver;
    }

    private String buildAppiumUrl() {
        StringBuilder sb = new
                StringBuilder("http://");
        sb.append(PropertyLoader.appiumRemoteHost)
                .append(":")
                .append(PropertyLoader.appiumRemotePort)
                .append(PropertyLoader.appiumRemotePath);
        return sb.toString();
    }

}
