package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.models.UserData;
import ge.tbc.testautomation.pages.RegisterPage;

public class RegisterSteps {
    Page page;
    RegisterPage registerPage;

    public RegisterSteps(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
    }

    public void registerUser(UserData user) {
        page.navigate(Constants.REGISTER_URL);

        registerPage.firstNameInput.fill(user.firstName);
        registerPage.lastNameInput.fill(user.lastName);
        registerPage.dobInput.fill(user.dob);
        registerPage.countrySelect.selectOption(user.countryCode);
        registerPage.postalCodeInput.fill(user.postalCode);
        registerPage.houseNumberInput.fill(user.houseNumber);
        registerPage.streetInput.fill(user.street);
        registerPage.cityInput.fill(user.city);
        registerPage.stateInput.fill(user.state);
        registerPage.phoneInput.fill(user.phone);
        registerPage.emailInput.fill(user.email);
        registerPage.passwordInput.fill(user.password);

        registerPage.registerSubmitButton.click();

        page.waitForURL(Constants.LOGIN_URL_PATTERN);
    }
}
