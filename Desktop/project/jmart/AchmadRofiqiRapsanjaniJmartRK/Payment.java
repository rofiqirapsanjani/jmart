package AchmadRofiqiRapsanjaniJmartRK;

public class Payment extends Invoice implements Transactor {
    public int productId;
    Shipment shipment;

    public Payment(int id, int buyerId, int productId, Shipment shipment) {
        super(id, buyerId, productId);
        this.shipment = shipment;
    }

    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        return false;
    }

    public double getTotalPay() {
        return 0.0;
    }

    @Override
    public Invoice perform() {
        // TODO Auto-generated method stub
        return null;
    }

}
