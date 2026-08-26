package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.ContactPage;

import java.nio.file.Path;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactSteps {

    private final Page page;
    private final ContactPage contactPage;
    public ContactSteps(Page page) {
        this.page = page;
        this.contactPage = new ContactPage(page);
    }

    public ContactSteps navigateToHomePage() {
        page.navigate(Constants.BASE_URL);
        return this;
    }

    public ContactSteps submitForm() {
        contactPage.submitButton.click();
        contactPage.submitButton.click();
        return this;
    }

    public ContactSteps verifyAllRequiredFieldErrorsAreShown() {
        assertThat(contactPage.firstNameError).hasText(Constants.FIRST_NAME_REQUIRED_ERROR);
        assertThat(contactPage.lastNameError).hasText(Constants.LAST_NAME_REQUIRED_ERROR);
        assertThat(contactPage.emailError).hasText(Constants.EMAIL_REQUIRED_ERROR);
        assertThat(contactPage.subjectError).hasText(Constants.SUBJECT_REQUIRED_ERROR);
        assertThat(contactPage.messageError).hasText(Constants.MESSAGE_REQUIRED_ERROR);
        return this;
    }

    public ContactSteps fillPersonalDetails(String firstName, String lastName, String email) {
        contactPage.firstNameInput.fill(firstName);
        contactPage.lastNameInput.fill(lastName);
        contactPage.emailInput.fill(email);

        assertThat(contactPage.firstNameError).hasCount(0);
        assertThat(contactPage.lastNameError).hasCount(0);
        assertThat(contactPage.emailError).hasCount(0);
        return this;
    }

    public ContactSteps selectSubject(String subjectValue) {
        contactPage.subjectSelect.selectOption(new SelectOption().setValue(subjectValue));

        assertThat(contactPage.subjectSelect).hasValue(subjectValue);
        assertThat(contactPage.subjectError).hasCount(0);
        return this;
    }

    public ContactSteps fillMessage(String message) {
        contactPage.messageTextarea.fill(message);
        contactPage.messageTextarea.press("Tab");
        return this;
    }
    public ContactSteps verifyMessageErrorHidden() {
        assertThat(contactPage.messageError).hasCount(0);
        return this;
    }

    public ContactSteps attachFile(Path file) {
        contactPage.attachmentInput.setInputFiles(file);
        return this;
    }

    public ContactSteps verifyInvalidFileTypeErrorIsShown() {
        assertThat(contactPage.attachmentError).hasText(Constants.ATTACHMENT_WRONG_TYPE_ERROR);
        return this;
    }

    public ContactSteps verifyFileAttachedSuccessfully(String fileName) {
        assertThat(contactPage.attachmentError).hasCount(0);
        assertThat(contactPage.attachmentInput).hasValue(Pattern.compile(fileName + "$"));
        return this;
    }

    public ContactSteps verifySubmitConfirmationIsShown() {
        assertThat(contactPage.successAlert).hasText(Constants.SUBMIT_CONFIRMATION);
        return this;
    }

    public ContactSteps verifyFormIsResetForNewSubmission() {
        assertThat(contactPage.firstNameInput).hasValue("");
        assertThat(contactPage.lastNameInput).hasValue("");
        assertThat(contactPage.emailInput).hasValue("");
        assertThat(contactPage.messageTextarea).hasValue("");
        assertThat(contactPage.subjectSelect).hasValue("");
        return this;
    }
}
