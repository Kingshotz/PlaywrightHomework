package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveFavouriteTest extends BaseTest {
    HomeSteps homeSteps;
    CommonSteps commonSteps;
    FavouritesSteps favouritesSteps;
    AuthSteps authSteps;
    SingleProductSteps singleProductSteps;
    String favouritedProductName;

    @BeforeClass
    public void innerSetup() {
        homeSteps = new HomeSteps(page);
        commonSteps = new CommonSteps(page);
        favouritesSteps = new FavouritesSteps(page);
        authSteps = new AuthSteps(page);
        singleProductSteps = new SingleProductSteps(page);
    }

    @Test(priority = 1, description = "Add a product to favourites (precondition)")
    public void addProductToFavourites() {
        commonSteps.navigateToHomePage();
        favouritedProductName = homeSteps.selectRandomProductAndOpen();
        singleProductSteps.addToFavourites();
    }

    @Test(priority = 2, description = "Go to favourites and remove the product")
    public void removeFavourite() {
        commonSteps.goToFavourites();
        favouritesSteps.removeFirstFavourite();
    }

    @Test(priority = 3, description = "Log out")
    public void logOut() {
        commonSteps.logOut();
    }

    @Test(priority = 4, description = "Log back in")
    public void logBackIn() {
        homeSteps.navigateToAuthPage();
        authSteps.authorize(testUser.email, testUser.password);
        page.waitForURL("**/account");
    }

    @Test(priority = 5, description = "Verify the product stays removed")
    public void validateProductStaysRemoved() {
        commonSteps.goToFavourites();
        Assert.assertFalse(favouritesSteps.getFavouriteProductNames().contains(favouritedProductName),
                "Removed product should no longer appear in favourites");
    }
}
