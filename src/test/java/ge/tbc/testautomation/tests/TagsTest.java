package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.CommonSteps;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.SingleProductSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TagsTest extends BaseTest {
    CommonSteps commonSteps;
    HomeSteps homeSteps;
    SingleProductSteps singleProductSteps;

    @BeforeClass
    public void innerSetup() {
        commonSteps = new CommonSteps(page);
        homeSteps = new HomeSteps(page);
        singleProductSteps = new SingleProductSteps(page);
        RegisterAndAuthorize();
    }

    @Test(priority = 1, description = "Go to Hand Tools category and filter by Hammer")
    public void goToHammerCategory() {
        commonSteps.goToHandToolsCategory();
        homeSteps.selectCategory(Constants.CATEGORY_HAMMER);
    }

    @Test(priority = 2, description = "Open Thor Hammer product page")
    public void openThorHammer() {
        homeSteps.openProductByName(Constants.THOR_HAMMER_PRODUCT_NAME);
        page.waitForURL(Constants.PRODUCT_URL_PATTERN);
    }

    @Test(priority = 3, description = "Validate the category tag on Thor Hammer's page is Hammer")
    public void validateTags() {
        Assert.assertEquals(singleProductSteps.getCategoryTag(), Constants.THOR_HAMMER_CATEGORY_TAG);
    }
}
