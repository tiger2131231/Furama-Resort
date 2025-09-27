package model.entity;

public class Employee extends Person {
    private String employeeLevel;
    private String jobPosition;
    private int salary;

    // Constructor chuẩn khớp với dữ liệu CSV
    public Employee(String id, String name, int birthday, String gender,
                    int phoneNumber, String email, int CCCD,
                    String employeeLevel, String jobPosition, int salary) {
        super(id, name, birthday, gender, CCCD, phoneNumber, email);
        this.employeeLevel = employeeLevel;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }



    @Override
    public String getInfoToCSV() {
        return this.getId() + ","
                + this.getName() + ","
                + this.getBirthday() + ","
                + this.getGender() + ","
                + this.getPhoneNumber() + ","
                + this.getEmail() + ","
                + this.getCCCD() + ","
                + this.getEmployeeLevel() + ","
                + this.getJobPosition() + ","
                + this.getSalary();
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", EmployeeLevel='" + employeeLevel + '\'' +
                ", JobPosition='" + jobPosition + '\'' +
                ", Salary=" + salary +
                '}';
    }
}
