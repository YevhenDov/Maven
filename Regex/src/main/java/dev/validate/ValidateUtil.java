package dev.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    public boolean phoneValidator(String userPhone) {
        Pattern p = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
        Matcher m = p.matcher(userPhone);
        return m.matches();
    }

    public boolean emailValidator(String userEmail) {
        Pattern p = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher m = p.matcher(userEmail);
        return m.matches();
    }

    public boolean dateValidator(String userDate) {
        Pattern p = Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");
        Matcher m = p.matcher(userDate);
        return m.matches();
    }

    public boolean ipValidator(String userIp) {
        Pattern p = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
        Matcher m = p.matcher(userIp);
        return m.matches();
    }
}
