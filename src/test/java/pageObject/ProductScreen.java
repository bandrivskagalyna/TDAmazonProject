package pageObject;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductScreen extends PageObjectInitializer {

    @FindBy(id = "skip_sign_in_button")
    private WebElement skipSignInButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"add-to-cart-button\"]")
    private WebElement addToCartButton;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }


    @Step("Wait until Product Page is loaded")
    public ProductScreen waitUntilProductVisible() {
        waitUntilElementVisible("//android.widget.TextView[@resource-id=\"title\"]");
        return this;
    }

    @Step("Retrieve Product price")
    public String getPrice() {
        WebElement priceEl = getElementIfPresent("//android.view.View[@resource-id=\"corePriceDisplay_mobile_feature_div\"]/android.widget.TextView");
        if (priceEl == null) {
            priceEl = driver.findElement(By.xpath("//android.view.View[@resource-id='corePrice_mobile_feature_div']/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView[1]"));
        }
        String productPrice = extractPrice(priceEl.getText());
        return productPrice;
    }

    @Step("Scroll to <<Add to Cart>> button")
    public ProductScreen scrollAddToCart() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(3).scrollIntoView(new UiSelector().resourceIdMatches(\"add-to-cart-button\"))"));
        return this;
    }

    @Step("Wait until <<Add to Cart>> button is visible")
    public ProductScreen waitUntilAddToCartBtnVisible() {
        waitUntilElementVisible("//android.widget.Button[@resource-id=\"add-to-cart-button\"]");
        return this;
    }

    @Step("Click on <<Add to Cart>> button")
    public ProductScreen clickAddToCart() {
        addToCartButton.click();
        return this;
    }
}
