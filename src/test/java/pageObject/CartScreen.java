package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartScreen extends PageObjectInitializer {

    @FindBy(xpath = "//android.view.View[@resource-id='sc-proceed-to-checkout-params-form']/android.view.View/android.view.View/android.widget.TextView[2]")
    private WebElement subtotalPriceElement;


    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Step("Wait until Cart Page is loaded")
    public CartScreen waitUntilCartPageLoaded() {
        waitUntilElementVisible("//android.view.View[@resource-id=\"sc-buy-box\"]");
        return this;
    }

    @Step("Retrieve subtotal price")
    public String getSubtotalPrice() {
        return extractPrice(subtotalPriceElement.getText());
    }
}
