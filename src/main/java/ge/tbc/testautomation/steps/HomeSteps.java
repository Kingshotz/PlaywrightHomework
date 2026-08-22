package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.pages.HomePage;

import java.util.Random;

public class HomeSteps {
    Page page;
    HomePage homePage;

    public HomeSteps(Page page) {
        this.page = page;
        homePage = new HomePage(page);
    }

    public HomeSteps navigateToAuthPage() {
        homePage.signInButton.click();
        return this;
    }

    public String selectRandomProductAndOpen() {
        homePage.productCards.first().waitFor(new Locator.WaitForOptions().setTimeout(10000));
        int count = homePage.productCards.count();
        int index = new Random().nextInt(count);
        Locator selected = homePage.productCards.nth(index);
        String name = selected.locator("[data-test='product-name']").textContent().trim();
        selected.click();
        return name;
    }

    public HomeSteps openProductByName(String productName) {
        homePage.productLinkByExactName(productName).click();
        return this;
    }

    public HomeSteps selectCategory(String categoryName) {
        homePage.productCards.first().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        homePage.categoryCheckbox(categoryName).check();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this;
    }

    public HomeSteps deselectCategory(String categoryName) {
        homePage.categoryCheckbox(categoryName).uncheck();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this;
    }
    public int getTotalProductCount() {
        int total = 0;
        while (true) {
            homePage.productCards.first().waitFor(new Locator.WaitForOptions().setTimeout(10000));
            total += homePage.productCards.count();

            Locator nextLi = homePage.paginationNextListItem();
            if (nextLi.count() == 0) break;
            String cls = nextLi.getAttribute("class");
            if (cls != null && cls.contains("disabled")) break;

            homePage.paginationNext.click();
            page.waitForLoadState(LoadState.NETWORKIDLE);
        }
        return total;
    }
}
