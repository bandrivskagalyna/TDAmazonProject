package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryScreen extends PageObjectInitializer {

    @FindBy(id = "skip_sign_in_button")
    private WebElement skipSignInButton;


    public EntryScreen(WebDriver driver) {
        super(driver);
    }

    @Step("Click Skip Sign In Button")
    public EntryScreen clickSkipSignInButton() {
        skipSignInButton.click();
        return this;
    }
}
