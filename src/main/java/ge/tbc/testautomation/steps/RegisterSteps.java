package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.models.UserData;
import ge.tbc.testautomation.pages.RegisterPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterSteps {
    Page page;
    RegisterPage registerPage;

    public RegisterSteps(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
    }



    public RegisterSteps fillValidRegistrationData(UserData user) {
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
        return this;
    }
    public  RegisterSteps submitRegistrationForm(){
        registerPage.registerSubmitButton.click();
        return this;
    }

    public RegisterSteps enterLeakedPasword(){
        registerPage.passwordInput.fill(Constants.DATA_LEAKED_PASSWORD);
        return this;
    }
    public RegisterSteps VerifyLeakedPasswordError(){
        assertThat(registerPage.registerError).isVisible();
        assertThat(registerPage.registerError).containsText("The given password has appeared in a data leak");
        return this;
    }

    public RegisterSteps enterValidPassword(UserData user){
        registerPage.passwordInput.fill(user.password);
        return this;
    }
}
