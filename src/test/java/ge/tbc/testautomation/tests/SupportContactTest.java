package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.pestashop.ContactUsSteps;
import ge.tbc.testautomation.steps.pestashop.HomeSteps;
import ge.tbc.testautomation.utils.TestDataGenerator;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class SupportContactTest {
    HomeSteps homeSteps;
    ContactUsSteps contactUsSteps;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeClass
    @Parameters({"browserType"})
    public void beforeClass(String browserType) {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);

        if(browserType.trim().equalsIgnoreCase("webKit")){
            browser = playwright.webkit().launch(launchOptions);
        }else if(browserType.trim().equalsIgnoreCase("chrome")){
            browser = playwright.chromium().launch(launchOptions);
        }else if(browserType.trim().equalsIgnoreCase("fireFox")){
            browser = playwright.firefox().launch(launchOptions);
        }else{
            throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }

        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();

        homeSteps = new HomeSteps(page);
        contactUsSteps = new ContactUsSteps(page);

        homeSteps.openHomePage();
    }
    @Test(priority = 1, description = "Verify email")
    public void verifyEmail() {
        homeSteps.VerifyMail();
    }
    @Test(priority = 2, description = "go to Contact Us Page")
    public void navigateToContactUs(){
        homeSteps.clickContactUsButton();
    }
    @Test(priority = 3, description = "Verify subject")
    public void verifySubject(){
        contactUsSteps.selectSubject("Customer service")
                .fillEmail("someMail@example.com")
                .fillMessage(Constants.MESSAGE);
    }

    @Test(priority = 4, description = "Upload File")
    public void testName() {
        contactUsSteps.attachFile(Paths.get(System.getProperty("user.dir"), "src/main/resources/file.txt"));
    }
    @Test(priority = 5, description = "submit and verify message sent suecessfully")
    public void verifyMessageSentSuccessfully() {
        contactUsSteps.submit()
                .verifySuccessMessageDisplayed();
    }
}
