package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FavouritesPage {
    public final Locator favouriteCards;

    public FavouritesPage(Page page) {
        favouriteCards = page.locator("[data-test^='favorite-']");
    }
}
