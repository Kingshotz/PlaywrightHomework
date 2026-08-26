package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.pages.HomePage;
import org.testng.Assert;

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
        Response res = page.waitForResponse(
                r->r.url().contains("/products"),
                ()->homePage.productLinkByExactName(productName).click()
        );
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
    public HomeSteps navigateToHomePage() {
        page.navigate("https://practicesoftwaretesting.com/");
        return this;
    }

    public HomeSteps verifyCatalogControlsVisible() {
        homePage.productCards.first().waitFor(new Locator.WaitForOptions().setTimeout(10000));
        Assert.assertTrue(homePage.productCards.count() > 0, "Product catalog should display at least one product");
        Assert.assertTrue(homePage.sortSelect.isVisible(), "Sort control should be visible");
        Assert.assertTrue(homePage.filtersPanel.isVisible(), "Filters panel should be visible");
        return this;
    }

    public HomeSteps searchForProduct(String term) {
        Response response = page.waitForResponse(
                r -> r.url().contains("api.practicesoftwaretesting.com/products/search"),
                () -> {
                    homePage.searchInput.fill(term);
                    homePage.searchSubmitButton.click();
                }
        );
        return this;
    }

    public HomeSteps resetSearch() {
        homePage.searchResetButton.click();
        return this;
    }

    public HomeSteps verifySearchResultsContainTerm(String term) {
        PlaywrightAssertions.assertThat(homePage.searchCaption).isVisible();
        int count = homePage.productCards.count();
        Assert.assertTrue(count > 0, "Search should return at least one product");
        for (int i = 0; i < count; i++) {
            String name = homePage.productCards.nth(i).locator("[data-test='product-name']").textContent();
            Assert.assertTrue(name.toLowerCase().contains(term.toLowerCase()),
                    "Product '" + name + "' should match search term '" + term + "'");
        }
        return this;
    }
    public HomeSteps selectBrand(String brandName) {
        homePage.checkboxByLabelText(brandName).check();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this;
    }

    public HomeSteps verifyFilteredProductsVisible() {
        homePage.productCards.first().waitFor(new Locator.WaitForOptions().setTimeout(10000));
        Assert.assertTrue(homePage.productCards.count() > 0, "Filtered results should show at least one product");
        return this;
    }
    public HomeSteps navigateToContactPage(){
        homePage.contactButton.click();
        return this;
    }

}
