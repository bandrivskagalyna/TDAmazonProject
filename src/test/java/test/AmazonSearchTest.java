package test;

import com.setup.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTest {

    @Test
    public void testAddToCartFlow() {
        PO.EntryScreen().clickSkipSignInButton();

        waitUntilLoaded(1000);

        PO.SearchScreen().clickSearchField()
                .enterSearchWord("Kindle")
                .waitUntilResultsAreLoaded()
                .scrollForward()
                .waitUntilResultsAreLoaded()
                .clickResultElement();

        PO.ProductScreen().waitUntilProductVisible();
        String productPrice = PO.ProductScreen().getPrice();

        PO.ProductScreen().scrollAddToCart()
                .waitUntilAddToCartBtnVisible()
                .clickAddToCart();

        PO.FooterBar().
                waitUntilElementAdded()
                .clickCartIcon();

        PO.CartScreen().waitUntilCartPageLoaded();
        String subtotalPrice = PO.CartScreen().getSubtotalPrice();

        Assert.assertEquals(subtotalPrice, productPrice, "Subtotal price should be the same as on product page");
    }


}