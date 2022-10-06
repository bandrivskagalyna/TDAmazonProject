package pageObject;

import configuration.BaseMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectInitializer extends BaseMethod {

    protected WebDriver driver;

    public PageObjectInitializer(WebDriver driver) {
        this.driver = driver;
    }

    public EntryScreen EntryScreen() {
        return PageFactory.initElements(driver, EntryScreen.class);
    }

    public SearchScreen SearchScreen() {
        return PageFactory.initElements(driver, SearchScreen.class);
    }

    public ProductScreen ProductScreen() {
        return PageFactory.initElements(driver, ProductScreen.class);
    }

    public FooterBar FooterBar() {
        return PageFactory.initElements(driver, FooterBar.class);
    }

    public CartScreen CartScreen() {
        return PageFactory.initElements(driver, CartScreen.class);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
