package model.repository;

import model.entity.Employee;
import utils.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String Employee_FILE = "src/data/Employee.csv";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(Employee_FILE);
            String[] array = null;
            // chuyển đổi kiểu stringList thành employeeList
            for (int i = 0; i < stringList.size(); i++) {
                array = stringList.get(i).split(",");
                Employee employee = new Employee(
                        array[0],                      // ID
                        array[1],                      // Name
                        Integer.parseInt(array[2]),    // Birthday
                        array[3],                      // Gender
                        Integer.parseInt(array[4]),    // PhoneNumber
                        array[5],                      // Email
                        Integer.parseInt(array[6]),    // CCCD
                        array[7],                      // EmployeeLevel (String)
                        array[8],                      // JobPosition (String)
                        Integer.parseInt(array[9])     // Salary
                );
                employeeList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("đọc bị lỗi");
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        List<String> list = new ArrayList<>();
        list.add(employee.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(Employee_FILE, list, true);
        } catch (IOException e) {
            System.out.println("loi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        List<Employee> employeeList = this.findAll();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {  // dùng equals cho String
                employeeList.remove(i);

                // Ghi lại file
                List<String> stringList = new ArrayList<>();
                for (Employee e : employeeList) {
                    stringList.add(e.getInfoToCSV());
                }

                try {
                    ReadAndWriteFile.writeListStringToCSV(Employee_FILE, stringList, false);
                } catch (IOException e) {
                    System.out.println("Lỗi ghi file: " + e.getMessage());
                }

                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isEditById(String id, Employee newEmployee) {
        List<Employee> employeeList = findAll();
        boolean isUpdated = false;

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                // Giữ nguyên ID cũ
                newEmployee.setId(id);
                employeeList.set(i, newEmployee);
                isUpdated = true;
                break;
            }
        }

        if (isUpdated) {
            List<String> stringList = new ArrayList<>();
            for (Employee e : employeeList) {
                stringList.add(e.getInfoToCSV());
            }
            try {
                ReadAndWriteFile.writeListStringToCSV(Employee_FILE, stringList, false);
            } catch (IOException e) {
                System.out.println("Lỗi ghi file khi update Employee");
                e.printStackTrace();
                return false;
            }
        }

        return isUpdated;
    }


    @Override
    public Employee findById(String id) {
        List<Employee> employeeList = this.findAll();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee; // trả về nhân viên tìm thấy
            }
        }
        return null; // không tìm thấy
    }


}

