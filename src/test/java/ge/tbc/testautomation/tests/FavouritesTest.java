package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.models.UserData;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FavouritesTest extends BaseTest {
    HomeSteps homeSteps;
    CommonSteps commonSteps;
    FavouritesSteps favouritesSteps;
    AuthSteps authSteps;
    SingleProductSteps singleProductSteps;
    String favouritedProductName;
    UserData testUser;


    @BeforeClass
    public void innerSetup() {
        homeSteps = new HomeSteps(page);
        commonSteps = new CommonSteps(page);
        favouritesSteps = new FavouritesSteps(page);
        authSteps = new AuthSteps(page);
        singleProductSteps = new SingleProductSteps(page);
        RegisterAndAuthorize();
        testUser = TestDataGenerator.generateUser();


    }

    @Test(priority = 1, description = "Add a random product to favourites")
    public void addRandomProductToFavourites() {
        commonSteps.navigateToHomePage();
        favouritedProductName = homeSteps.selectRandomProductAndOpen();
        singleProductSteps.addToFavourites();
    }

    @Test(priority = 2, description = "Log out")
    public void logOut() {
        commonSteps.signOut();
    }

    @Test(priority = 3, description = "Log back in")
    public void logBackIn() {
        homeSteps.navigateToAuthPage();
        authSteps.authorize(testUser.email, testUser.password);
        page.waitForURL("**/account");
    }

    @Test(priority = 4, description = "Check the product is still in favourites")
    public void validateProductStillInFavourites() {
        commonSteps.goToFavourites();
        Assert.assertTrue(favouritesSteps.getFavouriteProductNames().contains(favouritedProductName),
                "Expected '" + favouritedProductName + "' to still be in favourites");
    }
}
