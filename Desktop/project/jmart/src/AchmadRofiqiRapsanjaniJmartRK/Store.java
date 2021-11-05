package AchmadRofiqiRapsanjaniJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Store{
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z].{4,20}$";

    public String address;
    public double balance;
    public String name;
    public String phoneNumber;


    public Store(String name, String address, String phoneNumber ,double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString() {
        return
                "Name: "+this.name+
                        "\nemail: " +this.address+
                        "\npassword : " +this.phoneNumber+
                        "\nbalance : " +this.balance;
    }
    public boolean validate(){
        Pattern pat1 = Pattern.compile(REGEX_PHONE);
        Pattern pat2 = Pattern.compile(REGEX_NAME);

        Matcher match1 = pat1.matcher(name);
        Matcher match2 = pat2.matcher(phoneNumber);

        boolean temp = match1.find() && match2.find();
        return temp;
    }
}