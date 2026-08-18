package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.SingleProductPage;

public class SingleProductSteps {
    Page page;
    SingleProductPage singleProductPage;

    public SingleProductSteps(Page page) {
        this.page = page;
        singleProductPage = new SingleProductPage(page);
    }

    public SingleProductSteps addToFavourites() {
        singleProductPage.addToFavouritesButton.click();
        return this;
    }

    public String getCategoryTag() {
        return singleProductPage.categoryTag.textContent().trim();
    }

    public String getBrandTag() {
        return singleProductPage.brandTag.textContent().trim();
    }
}
