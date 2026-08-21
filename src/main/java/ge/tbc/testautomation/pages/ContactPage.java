package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContactPage {

    public final Page page;

    public final Locator firstNameInput;
    public final Locator lastNameInput;
    public final Locator emailInput;
    public final Locator subjectSelect;
    public final Locator messageTextarea;
    public final Locator attachmentInput;
    public final Locator submitButton;

    public final Locator firstNameError;
    public final Locator lastNameError;
    public final Locator emailError;
    public final Locator subjectError;
    public final Locator messageError;
    public final Locator attachmentError;

    public final Locator successAlert;

    public ContactPage(Page page) {
        this.page = page;

        this.firstNameInput = page.getByTestId("first-name");
        this.lastNameInput = page.getByTestId("last-name");
        this.emailInput = page.getByTestId("email");
        this.subjectSelect = page.getByTestId("subject");
        this.messageTextarea = page.getByTestId("message");
        this.attachmentInput = page.getByTestId("attachment");
        this.submitButton = page.getByTestId("contact-submit");

        this.firstNameError = page.getByTestId("first-name-error");
        this.lastNameError = page.getByTestId("last-name-error");
        this.emailError = page.getByTestId("email-error");
        this.subjectError = page.getByTestId("subject-error");
        this.messageError = page.getByTestId("message-error");
        this.attachmentError = page.getByTestId("attachment-error");

        this.successAlert = page.locator(".alert-success");
    }
}
