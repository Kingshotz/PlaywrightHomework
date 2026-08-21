package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductPage;
import org.testng.Assert;

public class ProductSteps {
    Page page;
    ProductPage productPage;

    public ProductSteps(Page page) {
        this.page = page;
        productPage = new ProductPage(page);
    }

    public ProductSteps verifyProductDetailsDisplayed() {
        Assert.assertTrue(productPage.productName.isVisible(), "Product name should be visible");
        Assert.assertTrue(productPage.unitPrice.isVisible(), "Price should be visible");
        Assert.assertTrue(productPage.productDescription.isVisible(), "Description should be visible");
        Assert.assertTrue(productPage.co2RatingBadge.isVisible(), "CO2 rating badge should be visible");
        Assert.assertTrue(productPage.quantityInput.isVisible(), "Quantity selector should be visible");
        return this;
    }

    public ProductSteps increaseQuantity() {
        productPage.increaseQuantityButton.click();
        return this;
    }

    public ProductSteps verifyQuantity(String expectedQuantity) {
        Assert.assertEquals(productPage.quantityInput.inputValue(), expectedQuantity);
        return this;
    }

    public ProductSteps addToCart() {
        productPage.addToCartButton.click();
        return this;
    }

    public ProductSteps verifyAddToCartToastShown(String expectedText) {
        productPage.addToCartToast.waitFor();
        Assert.assertTrue(productPage.addToCartToast.textContent().contains(expectedText),
                "Toast should confirm the product was added to the cart");
        return this;
    }
    public ProductSteps addToFavourites() {
        productPage.addToFavouritesButton.click();
        return this;
    }
}
