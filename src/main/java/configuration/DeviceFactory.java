package configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DeviceFactory {

    @Step("Create driver for device")
    public static WebDriver createDriver() throws Exception {
        WebDriver driver;

        String platform = PropertyLoader.platformName;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (platform) {

            case "Android":
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/Apps/Amazon/");
                File app = new File(appDir, "AmazonShopping.apk");

                capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
                capabilities.setCapability("deviceName", PropertyLoader.deviceName);
                capabilities.setCapability("platformName", platform);
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", PropertyLoader.appPackage);
                capabilities.setCapability("appActivity", PropertyLoader.appActivity);
                capabilities.setCapability("unicodeKeyboard", PropertyLoader.unicodeKeyboard);

                capabilities.setCapability("resetKeyboard", PropertyLoader.resetKeyboard);

                driver = new AndroidDriver(new URL(buildAppiumUrl()), capabilities);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

    private static String buildAppiumUrl() {
        StringBuilder sb = new
                StringBuilder("http://");
        sb.append(PropertyLoader.appiumRemoteHost)
                .append(":")
                .append(PropertyLoader.appiumRemotePort)
                .append(PropertyLoader.appiumRemotePath);
        return sb.toString();
    }
}
