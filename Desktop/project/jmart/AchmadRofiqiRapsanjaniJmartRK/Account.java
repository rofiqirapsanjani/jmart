package AchmadRofiqiRapsanjaniJmartRK;

public class Account extends Recognizable implements FileParser {
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super(id);
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

}
