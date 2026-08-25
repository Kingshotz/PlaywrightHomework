package ge.tbc.testautomation.data;

import ge.tbc.testautomation.models.RegistrationModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseSteps {
    public static List<RegistrationModel> getAllRegistrationModel(){
        List<RegistrationModel> registrationModels = new ArrayList<>();
        try(Connection connection = MSSQLConnection.getConnection()) {
            String SQL = "SELECT * FROM RegistrationData";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                registrationModels.add(new RegistrationModel(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getString("model"),
                        resultSet.getString("address1"),
                        resultSet.getString("address2"),
                        resultSet.getString("city"),
                        resultSet.getString("contact1"),
                        resultSet.getString("contact2")
                ));
            }
            return registrationModels;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
