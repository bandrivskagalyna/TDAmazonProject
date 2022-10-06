package configuration.data;

public class DeviceProperty {

    private String deviceName;
    private String platformName;
    private String appPackage;
    private String appActivity;
    private String unicodeKeyboard;
    private String resetKeyboard;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getUnicodeKeyboard() {
        return unicodeKeyboard;
    }

    public void setUnicodeKeyboard(String unicodeKeyboard) {
        this.unicodeKeyboard = unicodeKeyboard;
    }

    public String getResetKeyboard() {
        return resetKeyboard;
    }

    public void setResetKeyboard(String resetKeyboard) {
        this.resetKeyboard = resetKeyboard;
    }
}
