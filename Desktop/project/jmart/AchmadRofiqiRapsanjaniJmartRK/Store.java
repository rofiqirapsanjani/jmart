package AchmadRofiqiRapsanjaniJmartRK;

public class Store extends Recognizable implements FileParser {
    public String name;
    public String address;
    public String phoneNumber;
    public int id;

    public Store(int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public Store(int id, Account account, String name, String address, String phoneNumber) {
        super(id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }
}
