package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.models.UserData;
import ge.tbc.testautomation.steps.AuthSteps;
import ge.tbc.testautomation.steps.RegisterSteps;
import ge.tbc.testautomation.utils.TestDataGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected UserData testUser;
    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        playwright.selectors().setTestIdAttribute("data-test");

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
        testUser = TestDataGenerator.generateUser();
    }
    protected void RegisterAndAuthorize(){
        new RegisterSteps(page).fillValidRegistrationData(testUser);
        new AuthSteps(page).authorize(testUser.email, testUser.password);
        page.waitForURL(Constants.ACCOUNT_URL_PATTERN);
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
