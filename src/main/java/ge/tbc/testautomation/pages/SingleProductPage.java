package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SingleProductPage {
    public final Locator addToFavouritesButton;
    public final Locator categoryTag;
    public final Locator brandTag;

    public SingleProductPage(Page page) {
        addToFavouritesButton = page.getByTestId("add-to-favorites");
        categoryTag = page.locator("span[aria-label='category']");
        brandTag = page.locator("span[aria-label='brand']");
    }
}
