package model.entity;

public abstract class Person {
    private String id;
    private String name;
    private int birthday;
    private String  Gender;
    private int CCCD;
    private int PhoneNumber;
    private String Email;

    public Person() {
    }

    public Person(String id, String name, int birthday, String gender, int CCCD, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        Gender = gender;
        this.CCCD = CCCD;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public abstract String getInfoToCSV();

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", Gender='" + Gender + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Email=" + Email +
                ", CCCD=" + CCCD +
                '}';
    }


}
