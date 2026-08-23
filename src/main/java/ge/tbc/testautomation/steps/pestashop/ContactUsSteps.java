package ge.tbc.testautomation.steps.pestashop;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.pestashop.ContactUsPage;

import java.nio.file.Path;

public class ContactUsSteps {

    private final ContactUsPage contactUsPage;

    public ContactUsSteps(Page page) {
        this.contactUsPage = new ContactUsPage(page);
    }

    public ContactUsSteps selectSubject(String subject) {
        contactUsPage.subjectSelect.selectOption(
                new SelectOption().setLabel(subject));
        return this;
    }

    public ContactUsSteps fillEmail(String email) {
        contactUsPage.emailInput.fill(email);
        return this;
    }

    public ContactUsSteps fillMessage(String message) {
        contactUsPage.messageTextarea.fill(message);
        return this;
    }

    public ContactUsSteps attachFile(Path filePath) {
        contactUsPage.attachmentInput.setInputFiles(filePath);
        return this;
    }

    public ContactUsSteps submit() {
        contactUsPage.sendButton.click();
        return this;
    }

    public ContactUsSteps verifySuccessMessageDisplayed() {
        PlaywrightAssertions.assertThat(contactUsPage.successAlert).isVisible();
        return this;
    }
}
