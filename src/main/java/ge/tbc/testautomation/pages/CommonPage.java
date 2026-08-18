package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {
    public final Locator homeLogo;
    public final Locator accountMenuButton;
    public final Locator myFavouritesLink;
    public final Locator signOutLink;
    public final Locator categoriesDropdownButton;
    public final Locator handToolsLink;

    public CommonPage(Page page) {
        homeLogo = page.getByTestId("nav-home");
        accountMenuButton = page.getByTestId("nav-menu");
        myFavouritesLink = page.getByTestId("nav-my-favorites");
        signOutLink = page.getByTestId("nav-sign-out");

        categoriesDropdownButton = page.getByTestId("nav-categories");
        handToolsLink = page.getByTestId("nav-hand-tools");
    }
}
