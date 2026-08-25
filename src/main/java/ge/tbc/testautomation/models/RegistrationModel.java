package ge.tbc.testautomation.models;

public class RegistrationModel {
//    create table RegistrationData (
//            id int,
//            firstName varchar(50),
//    lastName varchar(50),
//    gender varchar(50),
//    model varchar(50),
//    address1 varchar(50),
//    address2 varchar(50),
//    city varchar(50),
//    contact1 varchar(50),
//    contact2 varchar(50),
//    primary key (id)
//);
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String Model;
    private String address1;
    private String address2;
    private String city;
    private String contact1;
    private String contact2;

    public RegistrationModel(int id, String firstName, String lastName, String gender, String model, String address1, String address2, String city, String contact1, String contact2) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        Model = model;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.contact1 = contact1;
        this.contact2 = contact2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }
    @Override
    public String toString() {
        return "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +
                ", model=" + Model + ", address1=" + address1 + ", address2=" + address2 +
                ", city=" + city + ", contact1=" + contact1 + ", contact2=" + contact2;
    }
}
