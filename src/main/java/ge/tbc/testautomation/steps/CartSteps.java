package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.CartPage;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartSteps {
    Page page;
    CartPage cartPage;

    public CartSteps(Page page) {
        this.page = page;
        cartPage = new CartPage(page);
    }

    // Confirmed live: the line/cart total only recalculates on blur, not on input,
    // so an explicit Tab press after fill() is required.
    public CartSteps setQuantity(String quantity) {
        String previousLineTotal = cartPage.linePrice.textContent();

        cartPage.productQuantityInput.fill(quantity);
        cartPage.productQuantityInput.press("Enter");

        assertThat(cartPage.linePrice).not().hasText(previousLineTotal);

        return this;
    }

    public CartSteps verifyCartTotalIsCorrect() {
        double unitPrice = parsePrice(cartPage.productPrice.textContent());
        int quantity = Integer.parseInt(cartPage.productQuantityInput.inputValue());
        double expectedTotal = unitPrice * quantity;

        double actualLineTotal = parsePrice(cartPage.linePrice.textContent());
        Assert.assertEquals(actualLineTotal, expectedTotal, 0.01, "Line total should equal unit price * quantity");
        return this;
    }

    public CartSteps proceedToCheckout() {
        cartPage.proceedToCheckoutButton.click();
        return this;
    }

    private double parsePrice(String text) {
        return Double.parseDouble(text.replace("$", "").trim());
    }
}
