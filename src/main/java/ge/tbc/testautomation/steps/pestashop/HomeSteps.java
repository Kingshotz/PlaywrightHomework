package ge.tbc.testautomation.steps.pestashop;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.pestashop.HomePage;
import org.testng.Assert;

public class HomeSteps {
    Page page;
    HomePage homePage;

    public HomeSteps(Page page) {
        this.page = page;
        homePage = new HomePage(page);
    }
    public HomeSteps openHomePage() {
        page.navigate(Constants.PESTASHOP_URL);
        homePage.shopFrame.owner().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        homePage.shopFrame().waitForLoadState(LoadState.LOAD);
        return this;
    }
    public HomeSteps clickContactUsButton() {
        homePage.contactUsButton.click();
        return this;
    }
    public  HomeSteps VerifyMail(){
        String mail = (String) homePage.mailTo.evaluate("el => el.textContent.trim()");
        Assert.assertEquals(mail, Constants.MAIL_TO);
        return this;
    }

}
