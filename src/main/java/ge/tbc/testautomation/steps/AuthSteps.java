package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.AuthPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AuthSteps {
    Page page;
    AuthPage authPage;

    public AuthSteps(Page page) {
        authPage = new AuthPage(page);
        this.page = page;
    }

    public AuthSteps goToRegisterPage() {
        authPage.RegisterButton.click();
        return this;
    }

    public AuthSteps authorize(String email, String password) {
        authPage.emailInput.waitFor(new Locator.WaitForOptions().setTimeout(10000));
        authPage.emailInput.fill(email);
        authPage.passwordInput.fill(password);
        authPage.loginButton.click();
        return this;
    }
    public  AuthSteps VerifyOnAccountPage() {
        assertThat(page).hasURL(Pattern.compile(".*/account$"));
        return this;
    }
    public AuthSteps verifyOnLoginPage() {
        assertThat(page).hasURL("https://practicesoftwaretesting.com/auth/login");
        return this;
    }
    public AuthSteps clickForgotPasswordLink() {
        authPage.forgotPasswordLink.click();
        return this;
    }
}
