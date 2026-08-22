package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class HomePage {
    private final Page page;
    public final Locator signInButton;
    public final Locator productCards;
    public final Locator paginationNext;

    public HomePage(Page page) {
        this.page = page;
        signInButton = page.getByTestId("nav-sign-in");
        productCards = page.locator("a[data-test^='product-']");
        paginationNext = page.getByTestId("pagination-next");
    }

    public Locator categoryCheckbox(String categoryName) {
        return page.locator("label")
                .filter(new Locator.FilterOptions().setHasText(
                        Pattern.compile("^\\s*" + Pattern.quote(categoryName) + "\\s*$")))
                .locator("input[type='checkbox']");
    }

    public Locator paginationNextListItem() {
        return page.locator("li.page-item:has([data-test='pagination-next'])");
    }

    public Locator productLinkByExactName(String productName) {
        return page.getByText(productName, new Page.GetByTextOptions().setExact(true));
    }
}
