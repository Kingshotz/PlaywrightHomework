package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.CommonPage;
import org.testng.Assert;

public class CommonSteps {
    Page page;
    CommonPage commonPage;

    public CommonSteps(Page page) {
        this.page = page;
        commonPage = new CommonPage(page);
    }

    public CommonSteps navigateToHomePage() {
        commonPage.homeLogo.click();
        page.waitForURL(Constants.BASE_URL);
        return this;
    }

    public CommonSteps waitForPageToLoad() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this;
    }

    public CommonSteps goToFavourites() {
        commonPage.accountMenuButton.click();
        commonPage.myFavouritesLink.click();
        page.waitForURL(Constants.FAVORITES_URL_PATTERN);
        return this;
    }

    public CommonSteps goToHandToolsCategory() {
        commonPage.categoriesDropdownButton.click();
        commonPage.handToolsLink.click();
        page.waitForURL(Constants.HAND_TOOLS_URL_PATTERN);
        return this;
    }

    public CommonSteps signOut() {
        commonPage.accountMenuButton.click();
        commonPage.signOutLink.click();
        page.getByTestId("nav-sign-in").waitFor();
        return this;
    }
    public CommonSteps verifyCartBadgeCount(String expectedCount) {
        Assert.assertEquals(commonPage.cartQuantityBadge.textContent().trim(), expectedCount);
        return this;
    }

    public CommonSteps goToCart() {
        commonPage.cartLink.click();
        page.waitForURL("**/checkout");
        return this;
    }
    public CommonSteps VerifyUserIsSignedIned(String firstName, String lastName) {
        PlaywrightAssertions.assertThat(commonPage.signInButton).isHidden();
        Locator userNameButton = commonPage.userNameButton(firstName, lastName);
        PlaywrightAssertions.assertThat(userNameButton).isVisible();
        return this;
    }
    public CommonSteps VerifyLoggedOut() {
        PlaywrightAssertions.assertThat(commonPage.signInButton).isVisible();
        return this;
    }
}
