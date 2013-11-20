package tc.lv.utils;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String EMAIL = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
    private static final int MIN_LENGHT_USERNAME = 4;
    private static final int MAX_LENGHT_USERNAME = 16;
    private static final int MIN_LENGHT_USER = 2;
    private static final int MAX_LENGHT_USER = 25;
    private static final int MIN_LENGHT_PASS = 6;
    private static final Pattern PATTERN_EMAIL = Pattern.compile(EMAIL);

    public static boolean isCorrectName(String userName) {
        return (userName.length() >= MIN_LENGHT_USERNAME) && (userName.length() <= MAX_LENGHT_USERNAME);
    }

    public static boolean isCorrectFirstName(String firstName) {
        return (firstName.length() >= MIN_LENGHT_USER) && (firstName.length() <= MAX_LENGHT_USER);
    }

    public static boolean isCorrectLastName(String lastName) {
        return (lastName.length() >= MIN_LENGHT_USER) && (lastName.length() <= MAX_LENGHT_USER);
    }

    public static boolean isCorrectEmail(String userEmail) {
        return PATTERN_EMAIL.matcher(userEmail).find();
    }

    public static boolean isCorrectPassword(String password) {
        return (password.length() >= MIN_LENGHT_PASS);
    }

}
