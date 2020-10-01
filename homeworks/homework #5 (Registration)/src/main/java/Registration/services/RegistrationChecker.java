package Registration.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationChecker {
    public static final Pattern EMAIL_REGEXP = Pattern.compile("[a-zA-Z0-9/-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
    public static final Pattern NAME_REGEXP = Pattern.compile("^[A-Z][a-z]+");

    public static boolean checkField(String field, Pattern pattern) {
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }
}
