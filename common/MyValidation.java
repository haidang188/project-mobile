package review.common;

import java.util.regex.Pattern;

public class MyValidation {
    public static boolean isValidName(String name) {
        String regex = "^[a-zA-Z ]+$";
        return Pattern.matches(regex, name);
    }

    public static boolean isValidAge(String birthday) {

        return false;
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidFormatBirthday(String birthday) {
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        if (Pattern.matches(regex, birthday)) {
            String[] birthdays = birthday.split("/");
            switch (Integer.parseInt(birthdays[1])) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (Integer.parseInt(birthdays[0]) < 32 && Integer.parseInt(birthdays[0]) > 0) {
                        return true;
                    } else {
                        return false;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (Integer.parseInt(birthdays[0]) < 31 && Integer.parseInt(birthdays[0]) > 0) {
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (isLeapYear(Integer.parseInt(birthdays[2])) && Integer.parseInt(birthdays[0]) < 30 && Integer.parseInt(birthdays[0]) > 0) {
                        return true;
                    } else {
                        return false;
                    }
            }
        }
        return false;
    }
}
