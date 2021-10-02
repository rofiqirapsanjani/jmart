package AchmadRofiqiRapsanjaniJmartRK;

public abstract class Invoice extends Recognizable implements FileParser {
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    enum Status {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
    }

    enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }

    protected Invoice(int id, int buyerId, int productId) {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "apapun";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    public abstract double getTotalPay();
}
