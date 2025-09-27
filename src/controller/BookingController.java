package controller;

import java.util.Scanner;

public class BookingController {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- BOOKING MANAGEMENT -----");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.print("Choose an option (1-6): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.println("Add new booking...");
                    break;
                case 2:
                    System.out.println("Display list booking...");
                    break;
                case 3:
                    System.out.println("Create new contracts...");
                    break;
                case 4:
                    System.out.println("Display list contracts...");
                    break;
                case 5:
                    System.out.println("Edit contracts...");
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        } while (choice != 6);
    }
}
