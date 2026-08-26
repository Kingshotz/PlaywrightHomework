package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.PaymentPage;

public class PaymentSteps {
    Page page;
    PaymentPage paymentPage;

    public PaymentSteps(Page page) {
        this.page = page;
        paymentPage = new PaymentPage(page);
    }

    public PaymentSteps selectPaymentMethod(String method) {
        paymentPage.paymentMethodSelect.selectOption(method);
        return this;
    }

    // 1st click on "finish": validates the payment method and shows an inline
    // "Payment was successful" message. The order is not placed yet at this point.
    public PaymentSteps confirmPayment() {
        paymentPage.confirmButton.click();
        return this;
    }
}
