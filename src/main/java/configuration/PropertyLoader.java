package configuration;

import configuration.data.DeviceProperty;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String appiumRemoteHost;
    public static String appiumRemotePort;
    public static String appiumRemotePath;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("./src/main/resources/appium.properties"));

            appiumRemoteHost = prop.getProperty("remoteHost");
            appiumRemotePort = prop.getProperty("remotePort");
            appiumRemotePath = prop.getProperty("remotePath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DeviceProperty loadProperties(String device) {
        DeviceProperty deviceProperty = new DeviceProperty();
        Properties properties = new Properties();
        String propertiesFilePath = String.format("./src/main/resources/device%s.properties", device);

        try {
            properties.load(new FileInputStream(propertiesFilePath));

            deviceProperty.setPlatformName(properties.getProperty("platformName"));
            deviceProperty.setDeviceName(properties.getProperty("deviceName"));
            deviceProperty.setAppPackage(properties.getProperty("appPackage"));
            deviceProperty.setAppActivity(properties.getProperty("appActivity"));
            deviceProperty.setUnicodeKeyboard(properties.getProperty("unicodeKeyboard"));
            deviceProperty.setResetKeyboard(properties.getProperty("resetKeyboard"));

        } catch (IOException e) {
            Reporter.log("Properties file is missing or invalid! Check path to file: " + propertiesFilePath);
            System.exit(0);
        }
        return deviceProperty;

    }

}
