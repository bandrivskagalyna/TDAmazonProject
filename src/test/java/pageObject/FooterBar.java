package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterBar extends PageObjectInitializer {

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"cart_count\")]")
    private WebElement cartIcon;


    public FooterBar(WebDriver driver) {
        super(driver);
    }

    @Step("Wait until product added to Cart")
    public FooterBar waitUntilElementAdded() {
        waitUntilElementVisible("//android.widget.TextView[(@resource-id=\"com.amazon.mShop.android.shopping:id/cart_count\") and contains(@text,\"1\")]");
        return this;
    }

    @Step("Click Cart icon")
    public FooterBar clickCartIcon() {
        cartIcon.click();
        return this;
    }
}
