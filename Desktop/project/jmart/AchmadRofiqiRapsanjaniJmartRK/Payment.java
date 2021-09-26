package AchmadRofiqiRapsanjaniJmartRK;

public class Payment extends Transaction implements FileParser {
    public int productId;
    ShipmentDuration shipmentDuration;

    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration) {
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;

    }

    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration) {
        super(id, buyerId, buyerId);
        this.shipmentDuration = shipmentDuration;
    }

    public boolean validate() {
        return false;
    }

    public Transaction perform() {
        return null;
    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }

}
