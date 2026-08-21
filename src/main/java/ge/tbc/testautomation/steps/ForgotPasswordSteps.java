package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ForgotPasswordPage;

public class ForgotPasswordSteps {
    Page page;
    ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordSteps(Page page) {
        this.page = page;
        forgotPasswordPage = new ForgotPasswordPage(page);
    }
    public ForgotPasswordSteps fillEmail(String email) {
        forgotPasswordPage.emailInput.fill(email);
        return this;
    }
    public ForgotPasswordSteps submit() {
        forgotPasswordPage.submitButton.click();
        return this;
    }
    public ForgotPasswordSteps verifyConfirmText() {
        forgotPasswordPage.confirmText.isVisible();
        return this;
    }

}
