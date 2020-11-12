package za.co.iqbusiness.onlineregistrationserver.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationUtils {

    public static boolean isIdNumberValid(String idNumber) {
        boolean isValid = true;
        try {
            Pattern pattern = Pattern.compile("[0-9]{13}");
            Matcher matcher = pattern.matcher(idNumber);

            if (!matcher.matches() || !isDateValid(idNumber.substring(0, 6))) {
                isValid = false;
            }

            int lastNumber = Integer.parseInt(String.valueOf(idNumber.charAt(idNumber.length() - 1)));
            String numberSection = idNumber.substring(0, idNumber.length() - 1);

            if (lastNumber != generateLuhnDigit(numberSection)) {
                isValid = false;
            }
        } catch (Exception ex) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isTelephoneNumberValid(String telephoneNumber) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(telephoneNumber);
        return matcher.matches();
    }

    private static boolean isDateValid(String date) {
        int year = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(2, 4));

        if (month < 1 || month > 12) {
            return false;
        }

        int day = Integer.parseInt(date.substring(4, 6));
        Calendar myCal = new GregorianCalendar(year, month, day);
        int maxDays = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day < 1 || day > maxDays) {
            return false;
        }

        return true;
    }

    private static int generateLuhnDigit(String input) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            int multiple = (count % 2) + 1;
            count++;
            int temp = multiple * Integer.parseInt(String.valueOf(input.charAt(i)));
            temp = (int) Math.floor(temp / 10) + (temp % 10);
            total += temp;
        }

        total = (total * 9) % 10;

        return total;
    }
}

