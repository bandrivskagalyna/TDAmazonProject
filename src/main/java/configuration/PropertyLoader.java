package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String platformName;

    public static String deviceName;

    public static String appPackage;

    public static String appActivity;

    public static String unicodeKeyboard;

    public static String resetKeyboard;

    public static String appiumRemoteHost;

    public static String appiumRemotePort;

    public static String appiumRemotePath;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("./src/main/resources/device.properties"));

            platformName = prop.getProperty("platformName");
            deviceName = prop.getProperty("deviceName");
            appPackage = prop.getProperty("appPackage");
            appActivity = prop.getProperty("appActivity");
            unicodeKeyboard = prop.getProperty("unicodeKeyboard");
            resetKeyboard = prop.getProperty("resetKeyboard");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

}
