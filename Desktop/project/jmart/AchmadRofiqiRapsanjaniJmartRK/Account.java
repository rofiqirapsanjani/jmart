package AchmadRofiqiRapsanjaniJmartRK;

public class Account extends Recognizable implements FileParser {
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.password = password;
        this.email = email;

    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }
}