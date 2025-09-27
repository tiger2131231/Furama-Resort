package controller;

import model.entity.Customer;
import model.service.CustomerService;
import model.service.ICustomerService;
import utils.CheckCustomerValidate;
import utils.InvalidInputException;
import view.CustomerView;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICustomerService customerService = new CustomerService();

    public static void displayMenu() throws InvalidInputException {
        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {
                case 1 -> displayCustomers();
                case 2 -> addCustomer();
                case 3 -> deleteCustomer();
                case 4 -> findCustomer();
                case 5 -> editCustomer();
                case 6 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        } while (choice != 6); // Thoát khi chọn 6
    }

    private static void showMenu() {
        System.out.println("----- CUSTOMER MANAGEMENT -----");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Delete customer");
        System.out.println("4. Find customer");
        System.out.println("5. Edit customer");
        System.out.println("6. Return main menu");
        System.out.print("Choose an option (1-6): ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // nhập sai sẽ rơi vào default
        }
    }

    private static void displayCustomers() {
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            CustomerView.displayList(customerList);
        }
    }

    private static void addCustomer() throws InvalidInputException {
        System.out.println("Add new customer...");
        Customer customer = CustomerView.inputDataForAddCustomer();
        if (customer == null) {
            System.out.println("Invalid customer data. Add failed!");
            return;
        }
        boolean isSuccess = customerService.add(customer);
        System.out.println(isSuccess ? "Add customer successfully!" : "Add customer failed!");
    }

    private static void deleteCustomer() throws InvalidInputException {
        System.out.print("\nEnter customer ID to delete (KH-YYYY): ");
        String deleteId = scanner.nextLine();

        CheckCustomerValidate.checkCustomerId(deleteId);

        boolean isDeleted = customerService.deleteById(deleteId);
        System.out.println(isDeleted ? "Delete customer successfully!" : "Customer not found!");

    }


    private static void findCustomer() {
        System.out.print("\nEnter customer ID to find (KH-YYYY): ");
        String findId = scanner.nextLine();

        Customer customer = customerService.findById(findId);
        if (customer == null) {
            System.out.println("Customer with ID " + findId + " not found.");
        } else {
            System.out.println("Customer found:");
            System.out.println(customer);
        }
    }


    private static void editCustomer() throws InvalidInputException {
        System.out.print("\nEnter customer ID to edit (KH-YYYY): ");
        String editId = scanner.nextLine();

        CheckCustomerValidate.checkCustomerId(editId); // validate ID

        Customer oldCustomer = customerService.findById(editId);
        if (oldCustomer == null) {
            System.out.println("Customer with ID " + editId + " not found.");
            return;
        }

        System.out.println("Enter new information for customer:");
        Customer newCustomer = CustomerView.inputDataForAddCustomer();
        if (newCustomer == null) {
            System.out.println("Invalid customer data. Update failed!");
            return;
        }

        boolean isSuccess = customerService.isEditById(editId, newCustomer);
        System.out.println(isSuccess ? "Update customer successfully!" : "Update customer failed!");
    }
}
