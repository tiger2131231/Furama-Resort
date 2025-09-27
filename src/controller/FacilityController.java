package controller;

import java.util.Scanner;

public class FacilityController {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- FACILITY MANAGEMENT -----");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.print("Choose an option (1-4): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.println("Display list facility...");
                    break;
                case 2:
                    System.out.println("Add new facility...");
                    break;
                case 3:
                    System.out.println("Display list facility maintenance...");
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        } while (choice != 4);
    }
}
