package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// Represents Step 1 (Cart) of the checkout wizard at /checkout.
public class CartPage {
    public final Locator productTitle;
    public final Locator productQuantityInput;
    public final Locator productPrice;
    public final Locator linePrice;
    public final Locator cartTotal;
    public final Locator continueShoppingButton;
    public final Locator proceedToCheckoutButton;

    public CartPage(Page page) {
        productTitle = page.getByTestId("product-title");
        productQuantityInput = page.getByTestId("product-quantity");
        productPrice = page.getByTestId("product-price");
        linePrice = page.getByTestId("line-price");
        cartTotal = page.getByTestId("cart-total");
        continueShoppingButton = page.getByTestId("continue-shopping");
        proceedToCheckoutButton = page.getByTestId("proceed-1");
    }
}
