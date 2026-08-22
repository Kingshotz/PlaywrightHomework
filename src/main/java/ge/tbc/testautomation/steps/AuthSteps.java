package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.AuthPage;

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
}
