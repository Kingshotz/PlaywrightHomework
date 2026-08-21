package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.models.GuestCheckoutData;
import ge.tbc.testautomation.pages.CheckoutPage;
import org.testng.Assert;

public class CheckoutSteps {
    Page page;
    CheckoutPage checkoutPage;

    public CheckoutSteps(Page page) {
        this.page = page;
        checkoutPage = new CheckoutPage(page);
    }

    public CheckoutSteps verifySignInStepDisplayed() {
        Assert.assertTrue(checkoutPage.emailInput.isVisible(), "Sign in step should show the login form by default");
        Assert.assertTrue(checkoutPage.guestTabLink.isVisible(), "Continue as Guest tab should be available");
        return this;
    }

    public CheckoutSteps switchToGuestTab() {
        checkoutPage.guestTabLink.click();
        return this;
    }

    public CheckoutSteps fillGuestInformation(GuestCheckoutData guestData) {
        checkoutPage.guestEmailInput.fill(guestData.email);
        checkoutPage.guestFirstNameInput.fill(guestData.firstName);
        checkoutPage.guestLastNameInput.fill(guestData.lastName);
        return this;
    }

    public CheckoutSteps continueAsGuest() {
        checkoutPage.guestSubmitButton.click();
        checkoutPage.proceedAsGuestButton.click();
        return this;
    }

    public CheckoutSteps fillBillingAddress(GuestCheckoutData guestData) {
        checkoutPage.countrySelect.selectOption(guestData.countryCode);
        checkoutPage.postalCodeInput.fill(guestData.postalCode);
        checkoutPage.houseNumberInput.fill(guestData.houseNumber);
        checkoutPage.streetInput.fill(guestData.street);
        checkoutPage.cityInput.fill(guestData.city);
        checkoutPage.stateInput.fill(guestData.state);
        return this;
    }

    public CheckoutSteps proceedToPayment() {
        checkoutPage.proceedToPaymentButton.click();
        return this;
    }
}
