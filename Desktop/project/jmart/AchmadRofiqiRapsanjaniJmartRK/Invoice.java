package AchmadRofiqiRapsanjaniJmartRK;

public class Invoice extends Recognizable implements FileParser {
    public String date;
    public int buyerId;
    public int productId;
    public int compaintId;
    public Rating rating;
    public Status status;

    public enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }

    public enum Status {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, FINISHED, FAILED
    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }

    public Invoice(int id, int buyerId, int productId) {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "20 02 2020";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;

    }

    public double getTotalPay() {
        return 0.0;
    }

}
