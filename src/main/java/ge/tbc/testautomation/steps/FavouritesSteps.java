package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.pages.FavouritesPage;

import java.util.List;
import java.util.stream.Collectors;

public class FavouritesSteps {
    Page page;
    FavouritesPage favouritesPage;

    public FavouritesSteps(Page page) {
        this.page = page;
        favouritesPage = new FavouritesPage(page);
    }

    public List<String> getFavouriteProductNames() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return favouritesPage.favouriteCards.locator("[data-test='product-name']")
                .allTextContents()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public FavouritesSteps removeFirstFavourite() {
        favouritesPage.favouriteCards.first().locator("[data-test='delete']").click();
        return this;
    }
}
