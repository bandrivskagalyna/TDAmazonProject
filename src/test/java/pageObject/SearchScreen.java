package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends PageObjectInitializer{

    @FindBy(id = "chrome_search_hint_view")
    private WebElement searchField;

    @FindBy(id = "rs_search_src_text")
    private WebElement searchInput;

    @FindBy(xpath = "(//android.view.View[@resource-id='search']/android.view.View)[3]")
    private WebElement resultElement;


    public SearchScreen(WebDriver driver) {
        super(driver);
    }

    @Step("Wait until search results are loaded")
    public SearchScreen waitUntilResultsAreLoaded() {
        waitUntilElementVisible("//android.view.View[@resource-id=\"search\"]");
        return this;
    }

    @Step("Click on search field")
    public SearchScreen clickSearchField() {
        searchField.click();
        return this;
    }

    @Step("Enter search word {searchWord}")
    public SearchScreen enterSearchWord(String searchWord) {
        searchInput.sendKeys(searchWord);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        return this;
    }

    @Step("Scroll forward")
    public SearchScreen scrollForward(){
        performForwardScrollByResourceId("search", 55);
        return this;
    }

    @Step("Click on result element")
    public SearchScreen clickResultElement(){
        resultElement.click();
        return this;
    }

}
