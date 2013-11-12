package tc.lv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String EMAIL = "(\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3})";

    public static boolean isCorrectName(String userName) {
	if ((userName.length() >= 4) && (userName.length() <= 16)) {
	    return true;
	} else {
	    return false;
	}
    }

    public static boolean isCorrectFirstName(String firstName) {
	if ((firstName.length() >= 2) && (firstName.length() <= 25)) {
	    return true;
	} else {
	    return false;
	}
    }

    public static boolean isCorrectLastName(String lastName) {
	if ((lastName.length() >= 2) && (lastName.length() <= 25)) {
	    return true;
	} else {
	    return false;
	}
    }

    public static boolean isCorrectEmail(String userEmail) {
	Matcher email;
	Pattern pattern = Pattern.compile(EMAIL);
	email = pattern.matcher(userEmail);
	if (email.find()) {
	    return true;
	}
	return true;
    }

    public static boolean isCorrectPassword(String password) {
	if ((password.length() >= 6)) {
	    return true;
	} else {
	    return false;
	}
    }

}
