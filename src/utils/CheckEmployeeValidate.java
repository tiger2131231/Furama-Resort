package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CheckEmployeeValidate {

    // 1. Mã NV: NV-YYYY
    public static void checkEmployeeId(String id) throws InvalidInputException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidInputException("Mã nhân viên không được để trống.");
        }
        String regex = "^NV-\\d{4}$";
        if (!Pattern.matches(regex, id)) {
            throw new InvalidInputException("Mã nhân viên không hợp lệ! Định dạng: NV-YYYY (ví dụ: NV-1234).");
        }
    }

    // 2. Tên NV: Viết hoa ký tự đầu
    public static void checkName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Tên nhân viên không được để trống.");
        }
        String regex = "^([A-ZÀ-Ỹ][a-zà-ỹ]*)(\\s[A-ZÀ-Ỹ][a-zà-ỹ]*)*$";
        if (!Pattern.matches(regex, name)) {
            throw new InvalidInputException("Tên nhân viên không hợp lệ! Mỗi từ phải viết hoa chữ cái đầu.");
        }
    }

    // 3. Tuổi >= 18 (tính cả ngày + tháng). Giả sử nhập theo dd/MM/yyyy
    public static void checkAge(String dob) throws InvalidInputException {
        if (dob == null || dob.trim().isEmpty()) {
            throw new InvalidInputException("Ngày sinh không được để trống.");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate now = LocalDate.now();

            if (birthDate.isAfter(now)) {
                throw new InvalidInputException("Ngày sinh không thể lớn hơn ngày hiện tại.");
            }

            int age = Period.between(birthDate, now).getYears();
            if (age < 18) {
                throw new InvalidInputException("Nhân viên phải đủ 18 tuổi trở lên.");
            }
        } catch (Exception e) {
            throw new InvalidInputException("Ngày sinh không hợp lệ! Định dạng dd/MM/yyyy");
        }
    }

    // 4. CMND 9 hoặc 12 số
    public static void checkCMND(String cmnd) throws InvalidInputException {
        if (cmnd == null || cmnd.trim().isEmpty()) {
            throw new InvalidInputException("CMND/CCCD không được để trống.");
        }
        String regex = "^(\\d{9}|\\d{12})$";
        if (!Pattern.matches(regex, cmnd)) {
            throw new InvalidInputException("CMND/CCCD không hợp lệ! Phải có 9 hoặc 12 chữ số.");
        }
    }

    // 5. Số điện thoại: bắt đầu từ 0, đủ 10 số
    public static void checkPhone(String phone) throws InvalidInputException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidInputException("Số điện thoại không được để trống.");
        }
        String regex = "^0\\d{9}$";
        if (!Pattern.matches(regex, phone)) {
            throw new InvalidInputException("Số điện thoại không hợp lệ! Phải bắt đầu bằng 0 và có đúng 10 số.");
        }
    }

    // 6. Lương > 0
    public static void checkSalary(double salary) throws InvalidInputException {
        if (salary <= 0) {
            throw new InvalidInputException("Lương phải lớn hơn 0.");
        }
        if (salary > 1_000_000_000) {
            throw new InvalidInputException("Lương nhập vào quá lớn! Vui lòng kiểm tra lại.");
        }
    }

    public static void checkCustomerId(String editId) {
    }
}