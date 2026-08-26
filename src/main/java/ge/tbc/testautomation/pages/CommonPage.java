package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CommonPage {
    private final Page page;
    public final Locator homeLogo;
    public final Locator accountMenuButton;
    public final Locator myFavouritesLink;
    public final Locator signOutLink;
    public final Locator categoriesDropdownButton;
    public final Locator handToolsLink;
    public final Locator cartLink;
    public final Locator cartQuantityBadge;
    public final Locator signInButton;

    public CommonPage(Page page) {
        this.page = page;
        signInButton = page.getByTestId("nav-sign-in");
        homeLogo = page.getByTestId("nav-home");
        accountMenuButton = page.getByTestId("nav-menu");
        myFavouritesLink = page.getByTestId("nav-my-favorites");
        signOutLink = page.getByTestId("nav-sign-out");

        categoriesDropdownButton = page.getByTestId("nav-categories");
        handToolsLink = page.getByTestId("nav-hand-tools");
        cartLink = page.getByTestId("nav-cart");
        cartQuantityBadge = page.getByTestId("cart-quantity");

    }
    public Locator userNameButton(String firstName, String lastName){
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(firstName + " " + lastName));
    }
}
