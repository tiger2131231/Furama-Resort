package model.entity;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String customerType, String address) {
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String id, String name, int birthday, String gender,
                    int CCCD, int phoneNumber, String email,
                    String customerType, String address) {
        super(id, name, birthday, gender, CCCD, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId() + ","
                + this.getName() + ","
                + this.getBirthday() + ","
                + this.getGender() + ","
                + this.getCCCD() + ","
                + this.getPhoneNumber() + ","
                + this.getEmail() + ","
                + this.getCustomerType() + ","
                + this.getAddress();
    }
}
