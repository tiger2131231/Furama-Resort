package model.repository;

import model.entity.Customer;
import utils.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static final String CUSTOMER_FILE = "src/data/customer.csv";

    // lấy tất cả Customer từ file
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(CUSTOMER_FILE);
            for (String line : stringList) {
                String[] array = line.split(",");
                Customer customer = new Customer(
                        array[0],                      // id
                        array[1],                      // name
                        Integer.parseInt(array[2]),    // birthday (năm sinh)
                        array[3],                      // gender
                        Integer.parseInt(array[4]),    // CCCD
                        Integer.parseInt(array[5]),    // phone number
                        array[6],                      // email
                        array[7],                      // customer type
                        array[8]                       // address
                );
                customerList.add(customer);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Customer");
        }
        return customerList;
    }

    // thêm Customer mới
    public boolean add(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Customer");
        }
        return false;
    }

    // tìm Customer theo id
    public Customer findById(String id) {
        List<Customer> customerList = this.findAll();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    // xóa Customer theo id
    public boolean deleteById(String id) {
        boolean isDeleted = false;
        List<Customer> customerList = this.findAll();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                customerList.remove(i);
                isDeleted = true;
                break;
            }
        }

        // ghi lại file
        List<String> stringList = new ArrayList<>();
        for (Customer c : customerList) {
            stringList.add(c.getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, false);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Customer");
        }

        return isDeleted;
    }

    // cập nhật Customer
    public boolean isEditById(String id, Customer newCustomer) {
        boolean isUpdated = false;
        List<Customer> customerList = this.findAll();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(newCustomer.getId())) {
                customerList.set(i, newCustomer);
                isUpdated = true;
                break;
            }
        }

        if (isUpdated) {
            List<String> stringList = new ArrayList<>();
            for (Customer c : customerList) {
                stringList.add(c.getInfoToCSV());
            }
            try {
                ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE, stringList, false);
            } catch (IOException e) {
                System.out.println("Lỗi ghi file Customer");
            }
        }

        return isUpdated;
    }
}
