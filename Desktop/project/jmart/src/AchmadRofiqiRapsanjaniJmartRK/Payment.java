package AchmadRofiqiRapsanjaniJmartRK;


import java.util.ArrayList;
import java.util.Date;

public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    ArrayList <Record> history = new ArrayList<>();

    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    @Override
    public double getTotalPay(){
        return 0.0;
    }
    public static class Record {
        public  Date date;
        public  String message;
        public Status status;
        public Record(Status status, String message){

        }

    }


}

