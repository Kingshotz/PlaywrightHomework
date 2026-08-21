package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.CommonSteps;
import ge.tbc.testautomation.steps.HomeSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterTest extends BaseTest {
    HomeSteps homeSteps;
    CommonSteps commonSteps;

    int countA;
    int countB;

    @BeforeClass
    public void innerSetup() {
        homeSteps = new HomeSteps(page);
        commonSteps = new CommonSteps(page);
        RegisterAndAuthorize();
    }

    // Sidebar "By category" filter: Hand Saw = 1 product, Wrench = 3 products (confirmed live).
    @Test(priority = 1, description = "Select Hand Saw in the sidebar filter and record product count")
    public void selectFirstCategory() {
        commonSteps.navigateToHomePage();
        homeSteps.selectCategory(Constants.CATEGORY_HAND_SAW);
        countA = homeSteps.getTotalProductCount();
    }

    @Test(priority = 2, description = "Switch to Wrench in the sidebar filter and record product count")
    public void selectSecondCategory() {
        homeSteps.deselectCategory(Constants.CATEGORY_HAND_SAW);
        homeSteps.selectCategory(Constants.CATEGORY_WRENCH);
        countB = homeSteps.getTotalProductCount();
    }

    @Test(priority = 3, description = "Select both sidebar checkboxes, validate combined count equals the sum")
    public void validateCombinedCountIsSum() {
        homeSteps.selectCategory(Constants.CATEGORY_HAND_SAW);
        int combinedCount = homeSteps.getTotalProductCount();
        Assert.assertEquals(combinedCount, countA + countB,
                "Combined sidebar category product count should equal the sum of each category individually");
    }
}
