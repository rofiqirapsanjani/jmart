package AchmadRofiqiRapsanjaniJmartRK;

public abstract class Transaction extends Recognizable {
    public enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }

    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    public Transaction(int id, int buyerId, int storeId) {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }

    public Transaction(int id, Account buyer, Store store) {
        super(id);
    }

    public boolean validate() {
        return false;
    }

    public Transaction perform() {
        return null;
    }

}