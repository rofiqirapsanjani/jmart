package AchmadRofiqiRapsanjaniJmartRK;

public class Payment extends Invoice implements Transactor {
    public Shipment shipment;
    public int productCount;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment) {
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Invoice perform() {
        return null;
    }

    @Override
    public double getTotalPay() {
        return 0.0;
    }

}