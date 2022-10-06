package configuration;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethod {

    public static WebDriver driver;
    protected static WebDriverWait wait;

    private static int WEB_DRIVER_WAIT = 10;

    protected void setDriverAndWait(WebDriver wd) {
        this.driver = wd;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WEB_DRIVER_WAIT));
    }

//    protected static WebDriver getDriver() {
//        return driver;
//    }

    protected void waitUntilLoaded(long millis) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
    }

    protected void waitUntilElementVisible(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    protected void performForwardScrollByResourceId(String resourceId, int scrollSteps) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\"" + resourceId + "\")).scrollForward(" + scrollSteps + ")"));
    }

    protected WebElement getElementIfPresent(String xpath) {
        WebElement el;
        try {
            el = driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException ex) {
            System.out.println("No element with xpath=" + xpath);
            return null;
        }
        return el;
    }

    protected String extractPrice(String price) {
        return price.substring(price.indexOf("$"));
    }

}
