package ge.tbc.testautomation.data;

import ge.tbc.testautomation.models.RegistrationModel;
import org.testng.annotations.DataProvider;

import java.util.List;

public class RegistrationDataProvider {
    @DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() {
        List<RegistrationModel>  models = DataBaseSteps.getAllRegistrationModel();
        return models.stream().map(model -> new Object[] { model }).toArray(Object[][]::new);
    }
}
