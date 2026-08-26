package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    private final Page page;
    public final Locator
            signInButton,
             productCards,
             paginationNext,
             sortSelect,
             searchInput,
             searchSubmitButton,
             searchResetButton,
             filtersPanel,
             searchCaption,
             contactButton;
    public HomePage(Page page) {
        this.page = page;
        signInButton = page.getByTestId("nav-sign-in");
        productCards = page.locator("a[data-test^='product-']");
        paginationNext = page.getByTestId("pagination-next");
        sortSelect = page.getByTestId("sort");
        searchInput = page.getByTestId("search-query");
        searchSubmitButton = page.getByTestId("search-submit");
        searchResetButton = page.getByTestId("search-reset");
        filtersPanel = page.locator("div[data-test='filters']");
        searchCaption = page.getByTestId("search-caption");
        contactButton = page.getByTestId("nav-contact");
    }

    public Locator categoryCheckbox(String categoryName) {
        return page.getByLabel(categoryName);
    }

    public Locator paginationNextListItem() {
        return page.locator("li.page-item:has([data-test='pagination-next'])");
    }

    public Locator productLinkByExactName(String productName) {
        return page.getByText(productName, new Page.GetByTextOptions().setExact(true));
    }
    public Locator checkboxByLabelText(String labelText) {
        return page.getByLabel(labelText);
    }

}
