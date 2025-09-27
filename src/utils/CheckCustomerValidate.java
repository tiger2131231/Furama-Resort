package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CheckCustomerValidate {
    private static final Pattern CUSTOMER_ID_REGEX = Pattern.compile("^KH-\\d{4}$");
    private static final Pattern NAME_REGEX = Pattern.compile("^([A-Z][a-z]*(\\s[A-Z][a-z]*)*)$");
    private static final Pattern CCCD_REGEX = Pattern.compile("^(\\d{9}|\\d{12})$");
    private static final Pattern PHONE_REGEX = Pattern.compile("^0\\d{9}$");

    // Kiểm tra ID KH-YYYY
    public static void checkCustomerId(String id) throws InvalidInputException {
        if (!CUSTOMER_ID_REGEX.matcher(id).matches()) {
            throw new InvalidInputException("Customer ID must follow format KH-YYYY (Y = digit).");
        }
    }

    // Kiểm tra tên khách hàng (Viết hoa chữ cái đầu)
    public static void checkCustomerName(String name) throws InvalidInputException {
        if (!NAME_REGEX.matcher(name).matches()) {
            throw new InvalidInputException("Name must capitalize the first letter of each word.");
        }
    }

    // Kiểm tra ngày sinh (>= 18 tuổi, tính cả ngày tháng)
    public static void checkBirthday(String birthday) throws InvalidInputException {
        try {
            LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate today = LocalDate.now();
            Period age = Period.between(birthDate, today);

            if (age.getYears() < 18 ||
                    (age.getYears() == 18 && (age.getMonths() > 0 || age.getDays() > 0))) {
                throw new InvalidInputException("Customer must be at least 18 years old.");
            }
        } catch (Exception e) {
            throw new InvalidInputException("Invalid birthday format. Use dd/MM/yyyy.");
        }
    }

    // Kiểm tra CMND/CCCD (9 hoặc 12 số)
    public static void checkCCCD(String cccd) throws InvalidInputException {
        if (!CCCD_REGEX.matcher(cccd).matches()) {
            throw new InvalidInputException("CCCD must be 9 or 12 digits.");
        }
    }

    // Kiểm tra số điện thoại (bắt đầu bằng 0, đủ 10 số)
    public static void checkPhoneNumber(String phone) throws InvalidInputException {
        if (!PHONE_REGEX.matcher(phone).matches()) {
            throw new InvalidInputException("Phone number must start with 0 and be 10 digits.");
        }
    }
}
