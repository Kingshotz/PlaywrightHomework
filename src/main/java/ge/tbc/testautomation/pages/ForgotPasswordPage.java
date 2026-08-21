package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ForgotPasswordPage {
    Page page;
    public Locator emailInput;
    public Locator submitButton;
    public Locator confirmText;

    public ForgotPasswordPage(Page page) {
        this.page = page;
        emailInput = page.getByTestId("email");
        submitButton = page.getByTestId("forgot-password-submit");
        confirmText = page.getByText("page.forgot-password.confirm");

    }
}
