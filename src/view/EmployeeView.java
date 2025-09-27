package view;

import model.entity.Employee;
import utils.CheckEmployeeValidate;
import utils.InvalidInputException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);

    private static final String[] employeeLevel = {
            "Trung cấp", "Cao đẳng", "Đại học", "Sau đại học"
    };

    private static final String[] jobPosition = {
            "Lễ tân", "Phục vụ", "Chuyên viên", "Giám sát", "Quản lý", "Giám đốc"
    };

    public static void displayList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            if (employee != null) {
                System.out.println(employee);
            } else {
                break;
            }
        }
    }

    public static Employee inputDataForAddEmployee() {
        try {
            // Mã nhân viên
            System.out.print("Nhập mã nhân viên (NV-YYYY): ");
            String idStr = scanner.nextLine();
            CheckEmployeeValidate.checkEmployeeId(idStr);

            // Tên
            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine();
            CheckEmployeeValidate.checkName(name);

            // Ngày sinh
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String dob = scanner.nextLine();
            CheckEmployeeValidate.checkAge(dob);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            int birthday = birthDate.getYear();

            // Giới tính
            System.out.print("Nhập giới tính: ");
            String gender = scanner.nextLine();

            // CMND/CCCD
            System.out.print("Nhập CMND/CCCD: ");
            String cmndStr = scanner.nextLine();
            CheckEmployeeValidate.checkCMND(cmndStr);
            int cccd = Integer.parseInt(cmndStr);

            // SĐT
            System.out.print("Nhập số điện thoại: ");
            String phoneStr = scanner.nextLine();
            CheckEmployeeValidate.checkPhone(phoneStr);
            int phone = Integer.parseInt(phoneStr);

            // Email
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            // Trình độ: chọn từ list
            System.out.println("Chọn trình độ:");
            for (int i = 0; i < employeeLevel.length; i++) {
                System.out.println((i + 1) + ". " + employeeLevel[i]);
            }
            int levelChoice = Integer.parseInt(scanner.nextLine());
            String level = employeeLevel[levelChoice - 1];

            // Vị trí: chọn từ list
            System.out.println("Chọn vị trí:");
            for (int i = 0; i < jobPosition.length; i++) {
                System.out.println((i + 1) + ". " + jobPosition[i]);
            }
            int jobChoice = Integer.parseInt(scanner.nextLine());
            String job_Position = jobPosition[jobChoice - 1];

            // Lương
            System.out.print("Nhập lương: ");
            int salary = Integer.parseInt(scanner.nextLine());
            CheckEmployeeValidate.checkSalary(salary);


            return new Employee(
                    idStr,
                    name,
                    birthday,
                    gender,
                    phone,
                    email,
                    cccd,
                    level,
                    job_Position,
                    salary
            );

        } catch (InvalidInputException e) {
            System.out.println(" Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Nhập sai định dạng dữ liệu!");
        }
        return null;
    }
}
