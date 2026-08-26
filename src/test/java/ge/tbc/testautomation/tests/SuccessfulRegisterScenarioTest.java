package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SuccessfulRegisterScenarioTest extends BaseTest {
    HomeSteps homeSteps;
    AuthSteps authSteps;
    RegisterSteps registerSteps;
    ProductSteps productSteps;
    CommonSteps commonSteps;
    FavouritesSteps favouritesSteps;
    ForgotPasswordSteps forgotPasswordSteps;

    @BeforeClass
    public void beforeClass() {
        homeSteps = new HomeSteps(page);
        authSteps = new AuthSteps(page);
        registerSteps = new RegisterSteps(page);
        productSteps = new ProductSteps(page);
        commonSteps = new CommonSteps(page);
        favouritesSteps = new FavouritesSteps(page);
        forgotPasswordSteps = new ForgotPasswordSteps(page);


        homeSteps.navigateToHomePage();
    }

    @Test(priority = 1,description = "go to authorization Page")
    public void goToAuthorizationPage() {
        homeSteps.navigateToAuthPage();
    }

    @Test(priority = 2, description = "go to register page")
    public void goToRegisterPage() {
        authSteps.goToRegisterPage();
    }
    @Test(priority = 3, description = "Fill form with data leak Password")
    public void fillFormWithLeakedPassword(){
        registerSteps.fillValidRegistrationData(testUser)
                .enterLeakedPasword()
                .submitRegistrationForm()
                .VerifyLeakedPasswordError();
    }
    @Test(priority = 4, description = "Enter Valid password")
    public void enterValidPassword(){
        registerSteps.enterValidPassword(testUser);
    }
    @Test(priority = 5, description = "Submit registration form")
    public void submitRegistrationForm(){
        registerSteps.submitRegistrationForm();
        authSteps.verifyOnLoginPage();
    }
    @Test(priority =6, description = "Auth with new user and verify")
    public void authWithNewUser(){
        authSteps.authorize(testUser.email, testUser.password)
                .VerifyOnAccountPage();

        homeSteps.navigateToHomePage();
        commonSteps.VerifyUserIsSignedIned(testUser.firstName, testUser.lastName);
    }
    @Test(priority = 7,description = "add product to favourites")
    public void addToFavourites() {
        homeSteps
                .openProductByName(Constants.THOR_HAMMER_PRODUCT_NAME);
        productSteps.addToFavourites();
    }
    @Test(priority = 8, description = "Check That product is in Favourites")
    public void checkThatProductIsInFavourites() {
        commonSteps.goToFavourites();
        favouritesSteps.VerifyProductIsInFavourites(Constants.THOR_HAMMER_PRODUCT_NAME);
    }

    @Test(priority = 9, description =  "Sign out")
    public void signOut(){
        commonSteps.signOut()
                .VerifyLoggedOut();

    }
    @Test(priority = 10, description = "Go to forgot password")
    public void goToforgotPassword() {

        authSteps.clickForgotPasswordLink();

        assertThat(page).hasURL(Pattern.compile(".*/auth/forgot-password$"));
    }
    @Test(priority = 11, description = " Enter the registered email address and verify a reset password confirmation is displayed.")
    public void enterRegisteredEmail(){
        forgotPasswordSteps.fillEmail(testUser.email)
                .submit()
                .verifyConfirmText();
    }


}
