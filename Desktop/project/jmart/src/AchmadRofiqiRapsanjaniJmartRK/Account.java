package AchmadRofiqiRapsanjaniJmartRK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable implements FileParser, Comparable<Serializable> {
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "[^A-Za-z0-9.&_*~]+@[^A-Za-z0-9.-]+\\.[A-Z]{2,4}";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])([a-zA-Z0-9@$!%*?&]{8,})$";

    public Account(int id, String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content) {
        return false;
    }

    @Override
    public String toString() {
        return ("name: " + name + "\nemail: " + email + "\npassword: " + password);
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        Pattern pattern_pass = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher_pass = pattern_pass.matcher(password);
        return matcher.find() && matcher_pass.find();
    }

}
