package ge.tbc.testautomation.utils;

import com.github.javafaker.Faker;
import ge.tbc.testautomation.models.UserData;

import java.text.SimpleDateFormat;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static UserData generateUser() {
        UserData user = new UserData();

        user.firstName = faker.name().firstName();
        user.lastName = faker.name().lastName();
        user.dob = new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday(18, 65));
        user.countryCode = "US";

        user.postalCode = faker.address().zipCode();
        user.houseNumber = String.valueOf(faker.number().numberBetween(1, 999));
        user.street = faker.address().streetName();
        user.city = faker.address().city();
        user.state = faker.address().state();
        user.phone = faker.number().digits(9);
        user.email = faker.internet().emailAddress().replace("@", "." + System.currentTimeMillis() + "@");
        user.password = faker.letterify("?????", true) + faker.letterify("?????", false) + faker.number().digits(2) + "!";
        return user;
    }
}
