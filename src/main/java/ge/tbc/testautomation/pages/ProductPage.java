package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    public final Locator productName;
    public final Locator unitPrice;
    public final Locator co2RatingBadge;
    public final Locator productDescription;
    public final Locator decreaseQuantityButton;
    public final Locator quantityInput;
    public final Locator increaseQuantityButton;
    public final Locator addToCartButton;
    public final Locator addToFavouritesButton;
    public final Locator addToCompareButton;
    public final Locator addToCartToast;

    public ProductPage(Page page) {
        productName = page.getByTestId("product-name");
        unitPrice = page.getByTestId("unit-price");
        co2RatingBadge = page.getByTestId("co2-rating-badge");
        productDescription = page.getByTestId("product-description");
        decreaseQuantityButton = page.getByTestId("decrease-quantity");
        quantityInput = page.getByTestId("quantity");
        increaseQuantityButton = page.getByTestId("increase-quantity");
        addToCartButton = page.getByTestId("add-to-cart");
        addToFavouritesButton = page.getByTestId("add-to-favorites");
        addToCompareButton = page.getByTestId("add-to-compare");
        // No data-test on the toast itself - it's an ngx-toastr style notification.
        addToCartToast = page.locator("[class*='toast']");
    }
}
