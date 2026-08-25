package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.data.RegistrationDataProvider;
import ge.tbc.testautomation.models.RegistrationModel;
import ge.tbc.testautomation.steps.techCanvas.RegisterSteps;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(description = "Tech Canvas Successful Register Test")
@Feature("Registration")
public class TechCanvasSuecessfulRegisterTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    RegisterSteps registerSteps;
    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.setDefaultTimeout(15000);
        registerSteps = new RegisterSteps(page);
    }

    @Test(priority = 1, description ="navigate to registration page")
    public void navigateToRegistrationPage() {
        registerSteps.navigateToRegistrationPage();

    }
    @Test(priority = 2, description ="fill registration form",
            dataProvider = "registrationData", dataProviderClass = RegistrationDataProvider.class)
    public void fillRegistrationForm(RegistrationModel model) {
        registerSteps.fillRegistrationForm(model)
                .checkDeliveryLocation();
    }
    @Test(priority = 3,description = "submit registration and verify")
    public void clickRegisterAndVerifyAlertText()
    {
        registerSteps.clickRegisterAndVerifyAlertText();
    }
    @AfterClass
    public void tearDown() {
        browserContext.close();
        browser.close();
        playwright.close();
    }
}