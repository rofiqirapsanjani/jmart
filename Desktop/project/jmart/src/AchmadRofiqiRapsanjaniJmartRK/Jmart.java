package AchmadRofiqiRapsanjaniJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart {
    // instance variables - replace the example below with your ow
    public static void main(String[] args) {
        Account testAccount = new Account(2, "Supriyono", "supriyono@ui.ac.id", "aku2AS");
        System.out.println(testAccount.validate());

        Complaint testComplaint = new Complaint(1, "Pengiriman tidak cepat,  kurir tersesat");
        System.out.println(testComplaint.toString());
    }

    Product createProduct() {
        return null;
    }

    Coupon createCoupon() {
        return null;
    }

    ShipmentDuration createShipmentDuration() {
        return null;
    }

}
