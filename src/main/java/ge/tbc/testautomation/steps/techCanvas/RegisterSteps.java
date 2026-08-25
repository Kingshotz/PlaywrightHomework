package ge.tbc.testautomation.steps.techCanvas;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.models.RegistrationModel;
import ge.tbc.testautomation.pages.techCanvas.RegisterPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.concurrent.atomic.AtomicReference;

public class RegisterSteps {
    private final Page page;
    private final RegisterPage registerPage;

    public RegisterSteps(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
    }
    @Step("Navigate to registration page")
    public RegisterSteps navigateToRegistrationPage() {
        page.navigate(Constants.TECH_CANVAS_REGISTER_URL);
        return this;
    }

    public RegisterSteps enterFirstName(String firstName) {
        registerPage.firstNameInput.fill(firstName);
        return this;
    }

    public RegisterSteps enterLastName(String lastName) {
        registerPage.lastNameInput.fill(lastName);
        return this;
    }

    public RegisterSteps selectGender(String gender) {
        Locator radio = gender.equalsIgnoreCase("male")
                ? registerPage.genderMaleRadio
                : registerPage.genderFemaleRadio;
        radio.check();
        return this;
    }

    public RegisterSteps selectModel(String modelLabel) {
        registerPage.modelSelect.selectOption(new SelectOption().setLabel(modelLabel));
        return this;
    }

    public RegisterSteps enterAddress1(String address1) {
        registerPage.address1Input.fill(address1);
        return this;
    }

    public RegisterSteps enterAddress2(String address2) {
        registerPage.address2Input.fill(address2);
        return this;
    }

    public RegisterSteps enterCity(String city) {
        registerPage.cityInput.fill(city);
        return this;
    }

    public RegisterSteps enterContact1(String contact1) {
        registerPage.contact1Input.fill(contact1);
        return this;
    }

    public RegisterSteps enterContact2(String contact2) {
        registerPage.contact2Input.fill(contact2);
        return this;
    }

    public RegisterSteps checkDeliveryLocation() {
        registerPage.deliveryLocationCheckbox.check();
        return this;
    }
    @Step("Fill registration form: {model}")
    public RegisterSteps fillRegistrationForm(RegistrationModel model) {
        return enterFirstName(model.getFirstName())
                .enterLastName(model.getLastName())
                .selectGender(model.getGender())
                .selectModel(model.getModel())
                .enterAddress1(model.getAddress1())
                .enterAddress2(model.getAddress2())
                .enterCity(model.getCity())
                .enterContact1(model.getContact1())
                .enterContact2(model.getContact2());
    }
    @Step("Click register and verify alert text")
    public RegisterSteps clickRegisterAndVerifyAlertText() {
        AtomicReference<String> alertText = new AtomicReference<>();
        page.onceDialog(dialog -> {
            alertText.set(dialog.message());
            dialog.accept();
        });
        registerPage.registerButton.click();
        String text = alertText.get();
        Assert.assertEquals(text, "Thanks for registering, we will get back to you shortly");

        return this;
    }
}