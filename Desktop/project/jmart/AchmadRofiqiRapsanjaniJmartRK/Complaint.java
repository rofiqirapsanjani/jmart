package AchmadRofiqiRapsanjaniJmartRK;

public class Complaint extends Transaction implements FileParser {
    public int paymentId;
    public String desc;

    public Complaint(int id, int buyerId, int storeId, int paymentID, String desc) {
        super(id, buyerId, storeId);
        this.paymentId = paymentID;
        this.desc = desc;

    }

    public Complaint(int id, Payment payment, String desc) {
        super(id, null, null);
        this.desc = desc;
        this.paymentId = id;

    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean validate() {
        return false;
    }

    public Transaction perform() {
        return null;
    }

}
