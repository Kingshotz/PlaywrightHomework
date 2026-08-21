package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.models.GuestCheckoutData;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.utils.TestDataGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SuccessfulPurchaseScenarioTest extends BaseTest {
    HomeSteps homeSteps;
    CommonSteps commonSteps;
    ProductSteps productSteps;
    CartSteps cartSteps;
    CheckoutSteps checkoutSteps;
    PaymentSteps paymentSteps;
    OrderConfirmationSteps orderConfirmationSteps;
    GuestCheckoutData guestData;

    @BeforeClass
    public void innerSetup() {
        homeSteps = new HomeSteps(page);
        commonSteps = new CommonSteps(page);
        productSteps = new ProductSteps(page);
        cartSteps = new CartSteps(page);
        checkoutSteps = new CheckoutSteps(page);
        paymentSteps = new PaymentSteps(page);
        orderConfirmationSteps = new OrderConfirmationSteps(page);

        guestData = TestDataGenerator.generateGuestCheckoutData();
    }

    @Test(priority = 1, description = "Verify the homepage catalog displays with filters, sorting and pagination")
    public void verifyCatalogDisplayed() {
        homeSteps.navigateToHomePage();
        homeSteps.verifyCatalogControlsVisible();
    }

    @Test(priority = 2, description = "Search for a product and verify the filtered results")
    public void searchForProduct() {
        homeSteps.searchForProduct(Constants.CATEGORY_HAMMER);
//        page.pause();
        homeSteps.verifySearchResultsContainTerm(Constants.CATEGORY_HAMMER);
    }

    @Test(priority = 3, description = "Apply category and brand filters and verify products filter correctly")
    public void applyCategoryAndBrandFilters() {
        homeSteps.selectCategory(Constants.FILTER_CATEGORY_HAND_TOOLS);
        homeSteps.selectBrand(Constants.FILTER_BRAND_FORGEFLEX);
        homeSteps.verifyFilteredProductsVisible();
    }

    @Test(priority = 4, description = "Open a product detail page and verify its information is displayed")
    public void openProductDetailPage() {
        homeSteps.openProductByName(Constants.SLEDGEHAMMER_PRODUCT_NAME);
        productSteps.verifyProductDetailsDisplayed();
    }

    @Test(priority = 5, description = "Increase the quantity to 2 and verify it updates")
    public void increaseQuantity() {
        productSteps.increaseQuantity();
        productSteps.verifyQuantity("2");
    }

    @Test(priority = 6, description = "Add the product to the cart and verify the toast and cart badge")
    public void addProductToCart() {
        productSteps.addToCart();
        commonSteps.verifyCartBadgeCount("2");
    }

    @Test(priority = 7, description = "Go to the cart and verify items, quantity and total price")
    public void goToCartAndValidateItem() {
        commonSteps.goToCart();
        cartSteps.verifyCartTotalIsCorrect();
    }

    @Test(priority = 8, description = "Modify the quantity in the cart and verify the total recalculates")
    public void modifyCartQuantity() {
        cartSteps.setQuantity("3");
        cartSteps.verifyCartTotalIsCorrect();
    }

    @Test(priority = 9, description = "Proceed to checkout and verify the Sign In step is shown")
    public void proceedToCheckout() {
        cartSteps.proceedToCheckout();
        checkoutSteps.verifySignInStepDisplayed();
    }

    @Test(priority = 10, description = "Continue as guest and fill in the guest checkout form")
    public void continueAsGuest() {
        checkoutSteps.switchToGuestTab();
        checkoutSteps.fillGuestInformation(guestData);
        checkoutSteps.continueAsGuest();
    }

    @Test(priority = 11, description = "Complete the billing address step and proceed to payment")
    public void fillBillingAddress() {
        checkoutSteps.fillBillingAddress(guestData);
        checkoutSteps.proceedToPayment();
    }

    @Test(priority = 12, description = "Select a payment method and complete the order")
    public void completeOrder() {
        paymentSteps.selectPaymentMethod(Constants.PAYMENT_METHOD_CASH_ON_DELIVERY);
        paymentSteps.confirmPayment();
        orderConfirmationSteps.completeOrder();
    }

    @Test(priority = 13, description = "Validate the order confirmation is received")
    public void validateOrderConfirmation() {
        orderConfirmationSteps.verifyOrderConfirmationReceived();
    }
}
