package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AuthPage {
    public Locator RegisterButton;
    public Locator emailInput;
    public Locator passwordInput;
    public Locator loginButton;
    public Locator forgotPasswordLink;

    public AuthPage(Page page) {
        RegisterButton = page.getByTestId("register-link");
        emailInput = page.getByTestId("email");
        passwordInput = page.getByTestId("password");
        loginButton = page.getByTestId("login-submit");
        forgotPasswordLink = page.getByTestId("forgot-password-link");
    }
}
