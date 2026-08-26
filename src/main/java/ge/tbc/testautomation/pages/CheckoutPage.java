package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// Represents Steps 2 (Sign In / Guest) and 3 (Billing Address) of the checkout wizard.
public class CheckoutPage {
    // Sign in step
    public final Locator emailInput;
    public final Locator passwordInput;
    public final Locator loginSubmitButton;
    // The "Continue as Guest" tab has no data-test attribute - it's a Bootstrap tab
    // identified by its href fragment.
    public final Locator guestTabLink;
    public final Locator guestEmailInput;
    public final Locator guestFirstNameInput;
    public final Locator guestLastNameInput;
    public final Locator guestSubmitButton;
    public final Locator proceedAsGuestButton;

    // Billing address step
    public final Locator countrySelect;
    public final Locator postalCodeInput;
    public final Locator houseNumberInput;
    public final Locator streetInput;
    public final Locator cityInput;
    public final Locator stateInput;
    public final Locator proceedToPaymentButton;

    public CheckoutPage(Page page) {
        emailInput = page.getByTestId("email");
        passwordInput = page.getByTestId("password");
        loginSubmitButton = page.getByTestId("login-submit");

        guestTabLink = page.locator("a[href='#guest-tab']");
        guestEmailInput = page.getByTestId("guest-email");
        guestFirstNameInput = page.getByTestId("guest-first-name");
        guestLastNameInput = page.getByTestId("guest-last-name");
        guestSubmitButton = page.getByTestId("guest-submit");
        proceedAsGuestButton = page.getByTestId("proceed-2-guest");

        countrySelect = page.getByTestId("country");
        postalCodeInput = page.getByTestId("postal_code");
        houseNumberInput = page.getByTestId("house_number");
        streetInput = page.getByTestId("street");
        cityInput = page.getByTestId("city");
        stateInput = page.getByTestId("state");
        proceedToPaymentButton = page.getByTestId("proceed-3");
    }
}
