package controller;

import model.entity.Employee;
import model.service.EmployeeService;
import model.service.IEmployeeService;
import utils.CheckEmployeeValidate;
import utils.InvalidInputException;
import view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IEmployeeService employeeService = new EmployeeService();

    public static void displayMenu() {
        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {
                case 1 -> displayEmployees();
                case 2 -> addEmployee();
                case 3 -> deleteEmployee();
                case 4 -> findEmployee();
                case 5 -> editEmployee();
                case 6 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private static void showMenu() {
        System.out.println("----- EMPLOYEE MANAGEMENT -----");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Delete employee");
        System.out.println("4. Find customer");
        System.out.println("5. Edit employee");
        System.out.println("6. Return main menu");
        System.out.print("Choose an option (1-4): ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // lựa chọn không hợp lệ
        }
    }

    private static void displayEmployees() {
        List<Employee> employeeList = employeeService.findAll();
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            EmployeeView.displayList(employeeList);
        }
    }

    private static void addEmployee() {
        System.out.println("Add new employee...");
        Employee employee = EmployeeView.inputDataForAddEmployee();
        if (employee == null) {
            System.out.println("Invalid employee data. Add failed!");
            return;
        }
        boolean isSuccess = employeeService.add(employee);
        System.out.println(isSuccess ? "Add employee successfully!" : "Add employee failed!");
    }
    private static void deleteEmployee() {
        System.out.print("\nEnter employee ID to delete (NV-YYYY): ");
        String deleteId = scanner.nextLine();

        try {
            CheckEmployeeValidate.checkEmployeeId(deleteId); // validate ID

            boolean isSuccess = employeeService.deleteById(deleteId);
            System.out.println(isSuccess ? "Delete employee successfully!" : "Employee with ID " + deleteId + " not found.");

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void findEmployee() {
        System.out.print("\nEnter employee ID to find (NV-YYYY): ");
        String findId = scanner.nextLine();

        try {
            CheckEmployeeValidate.checkEmployeeId(findId);

            Employee employee = employeeService.findById(findId);
            if (employee == null) {
                System.out.println("Employee with ID " + findId + " not found.");
            } else {
                System.out.println("Employee found:");
                System.out.println(employee);
            }

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editEmployee() {
        System.out.print("\nEnter employee ID to edit (NV-YYYY): ");
        String editId = scanner.nextLine();

        try {
            CheckEmployeeValidate.checkEmployeeId(editId); // validate ID

            Employee oldEmployee = employeeService.findById(editId);
            if (oldEmployee == null) {
                System.out.println("Employee with ID " + editId + " not found.");
                return;
            }

            System.out.println("Enter new information for employee:");
            Employee newEmployee = EmployeeView.inputDataForAddEmployee();
            if (newEmployee == null) {
                System.out.println("Invalid employee data. Update failed!");
                return;
            }

            boolean isSuccess = employeeService.isEditById(editId, newEmployee);
            System.out.println(isSuccess ? "Update employee successfully!" : "Update employee failed!");

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
