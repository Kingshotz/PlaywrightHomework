package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// Represents Step 4 (Payment) and the final order-confirmation state.
public class PaymentPage {
    public final Locator paymentMethodSelect;
    // Confirmed live: this single button (data-test="finish") is clicked TWICE.
    // 1st click: validates the selected payment method, shows an inline
    //            "Payment was successful" message, button stays labelled "Confirm".
    // 2nd click: actually places the order and swaps the whole wizard body for
    //            the #order-confirmation message.
    public final Locator confirmButton;
    // No data-test on the confirmation message - it has a stable id instead.
    public final Locator orderConfirmationMessage;

    public PaymentPage(Page page) {
        paymentMethodSelect = page.getByTestId("payment-method");
        confirmButton = page.getByTestId("finish");
        orderConfirmationMessage = page.getByTestId("payment-success-message");
    }
}
