package AchmadRofiqiRapsanjaniJmartRK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser {
    public String name;
    public String address;
    public String phoneNumber;
    public final String REGEX_PHONE = "[0-9]{9,12}";
    public final String REGEX_NAME = "A-Z][a-zA-Z0-9\s{2,}]{3,19}";

    // constructors
    public Store(int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean read(String content) {
        return false;
    }

    @Override
    public String toString() {
        return ("name: " + name + "\naddress: " + address + "\nphoneNumber: " + phoneNumber);
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Pattern pattern_phone = Pattern.compile(REGEX_PHONE);
        Matcher matcher_phone = pattern_phone.matcher(phoneNumber);
        return matcher.find() && matcher_phone.find();
    }

}
