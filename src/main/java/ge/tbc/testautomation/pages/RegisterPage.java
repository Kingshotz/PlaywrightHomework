package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    public Locator firstNameInput;
    public Locator lastNameInput;
    public Locator dobInput;
    public Locator countrySelect;
    public Locator postalCodeInput;
    public Locator houseNumberInput;
    public Locator streetInput;
    public Locator cityInput;
    public Locator stateInput;
    public Locator phoneInput;
    public Locator emailInput;
    public Locator passwordInput;
    public Locator registerSubmitButton;
    public Locator registerError;

    public RegisterPage(Page page) {
        this.firstNameInput = page.getByTestId("first-name");
        this.lastNameInput = page.getByTestId("last-name");
        this.dobInput = page.getByTestId("dob");
        this.countrySelect = page.getByTestId("country");
        this.postalCodeInput = page.getByTestId("postal_code");
        this.houseNumberInput = page.getByTestId("house_number");
        this.streetInput = page.getByTestId("street");
        this.cityInput = page.getByTestId("city");
        this.stateInput = page.getByTestId("state");
        this.phoneInput = page.getByTestId("phone");
        this.emailInput = page.getByTestId("email");
        this.passwordInput = page.getByTestId("password");
        this.registerSubmitButton = page.getByTestId("register-submit");
        registerError = page.locator("[data-test='register-error']");
    }
}
