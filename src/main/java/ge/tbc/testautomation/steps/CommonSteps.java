package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.CommonPage;

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

    public CommonSteps logOut() {
        commonPage.accountMenuButton.click();
        commonPage.signOutLink.click();
        page.getByTestId("nav-sign-in").waitFor();
        return this;
    }
}
