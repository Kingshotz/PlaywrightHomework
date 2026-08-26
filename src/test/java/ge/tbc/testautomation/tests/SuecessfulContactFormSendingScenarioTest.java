package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.ContactSteps;
import ge.tbc.testautomation.steps.HomeSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SuecessfulContactFormSendingScenarioTest extends BaseTest {
    HomeSteps homeSteps;
    ContactSteps contactSteps;

    @BeforeClass
    public void beforeClass() {
        homeSteps = new HomeSteps(page);
        contactSteps = new ContactSteps(page);
    }

    @Test(priority = 1, description = " Navigate to the homepage and click \"Contact\" in the navigation menu.")
    public void goToContactPage() {
        homeSteps.navigateToHomePage()
                .navigateToContactPage();
        assertThat(page).hasURL(Pattern.compile(".*/contact$"));
    }

    @Test(priority = 2, description = " Attempt to submit the empty form and verify validation errors appear for all required fields (First name, Last name, Email, Message).")
    public void submitEmptyForm() {
        contactSteps.submitForm()
                .verifyAllRequiredFieldErrorsAreShown();
    }

    @Test(priority = 3,
            description = " Fill first name, last name and email with valid data")
    public void fillPersonalDetails() {
        contactSteps.fillPersonalDetails
                (testUser.firstName,
                        testUser.lastName,
                        testUser.email);

    }

    @Test(priority = 4,
            description = "Select a subject from the dropdown")
    public void selectSubject() {
        contactSteps.selectSubject(Constants.SUBJECT_CUSTOMER_SERVICE);
    }
    @Test(priority = 5,
            description = " Enter a message in the Message textarea")
    public void fillMessage() {
        contactSteps
                .fillMessage(Constants.MESSAGE)
                .verifyMessageErrorHidden();
    }
    @Test(priority = 6,
            description = "Attach invalid file")
    public void attachInvalidFile() {
        contactSteps.attachFile(Paths.get(System.getProperty("user.dir"), Constants.INVALID_CONTACT_FORM_FILE_PATH));
    }
    @Test(priority = 7,
            description = "Attach invalid file")
    public void attachValidFile() {
        contactSteps.attachFile(Paths.get(System.getProperty("user.dir"), Constants.VALID_CONTACT_FORM_FILE_PATH))
                .verifyFileAttachedSuccessfully("valid.txt");
    }
    @Test(priority = 8,
            description = "Submitting valid data shows the success confirmation")
    public void submitFormAndVerifyConfirmation() {
        contactSteps.submitForm()
                .verifySubmitConfirmationIsShown();
    }
}
