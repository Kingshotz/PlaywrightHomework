package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.PaymentPage;
import org.testng.Assert;

public class OrderConfirmationSteps {
    Page page;
    PaymentPage paymentPage;

    public OrderConfirmationSteps(Page page) {
        this.page = page;
        paymentPage = new PaymentPage(page);
    }

    // 2nd click on "finish": actually places the order and swaps the wizard body
    // for the #order-confirmation message.
    public OrderConfirmationSteps completeOrder() {
        paymentPage.confirmButton.click();
        return this;
    }

    public OrderConfirmationSteps verifyOrderConfirmationReceived() {
        PlaywrightAssertions.assertThat(paymentPage.orderConfirmationMessage).isVisible();
        return this;
    }
}
