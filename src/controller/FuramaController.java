package controller;

import utils.InvalidInputException;
import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMainMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number 1-6.");
                choice = -1;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("➡ Employee Management selected.");
                    EmployeeController.displayMenu();
                }
                case 2 -> {
                    System.out.println("➡ Customer Management selected.");
                    CustomerController.displayMenu();
                }
                case 3 -> {
                    System.out.println("➡ Facility Management selected.");
                    FacilityController.displayMenu();
                }
                case 4 -> {
                    System.out.println("➡ Booking Management selected.");
                    BookingController.displayMenu();
                }
                case 5 -> {
                    System.out.println("➡ Promotion Management selected.");
                    PromotionController.displayMenu();
                }
                case 6 -> System.out.println(" Exiting program. Goodbye!");
                default -> System.out.println(" Invalid choice, please try again.");
            }
            System.out.println();
        } while (choice != 6);
    }

    private static void printMainMenu() {
        System.out.println("===== FURAMA RESORT MANAGEMENT =====");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.print("👉 Please choose an option (1-6): ");
    }
}
