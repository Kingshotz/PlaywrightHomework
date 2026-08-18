package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignleProductPage {

    public Locator addToFavouritesButton;

    public SignleProductPage(Page page) {
        addToFavouritesButton = page.getByTestId("add-to-favorites");
    }
}
