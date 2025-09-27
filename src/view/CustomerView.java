package view;

import model.entity.Customer;
import utils.CheckEmployeeValidate;
import utils.InvalidInputException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final String[] CUSTOMER_TYPES = {
            "Diamond", "Platinum", "Gold", "Silver"
    };

    // Nhập dữ liệu tạo mới Customer
    public static Customer inputDataForAddCustomer() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID khách hàng (KH-XXXX): ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String dob = scanner.nextLine();
        CheckEmployeeValidate.checkAge(dob);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        int birthday = birthDate.getYear();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập số CCCD: ");
        int cccd = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập số điện thoại: ");
        int phone = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        // Chọn loại khách hàng từ mảng CUSTOMER_TYPES
        System.out.println("Chọn loại khách hàng: ");
        for (int i = 0; i < CUSTOMER_TYPES.length; i++) {
            System.out.println((i + 1) + ". " + CUSTOMER_TYPES[i]);
        }
        int typeChoice;
        while (true) {
            System.out.print("Nhập lựa chọn (1-" + CUSTOMER_TYPES.length + "): ");
            typeChoice = Integer.parseInt(scanner.nextLine());
            if (typeChoice >= 1 && typeChoice <= CUSTOMER_TYPES.length) {
                break;
            }
            System.out.println(" Lựa chọn không hợp lệ, vui lòng nhập lại!");
        }
        String customerType = CUSTOMER_TYPES[typeChoice - 1];

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        return new Customer(id, name, birthday, gender, cccd, phone, email, customerType, address);
    }

    // Hiển thị danh sách Customer
    public static void displayList(List<Customer> customerList) {
        if (customerList == null || customerList.isEmpty()) {
            System.out.println("Danh sách khách hàng trống!");
            return;
        }
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
