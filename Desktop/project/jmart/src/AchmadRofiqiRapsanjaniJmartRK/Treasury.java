package AchmadRofiqiRapsanjaniJmartRK;

public class Treasury
{
    static double COMMISSION_MULTIPLIER = 0.05;
    static double BOTTOM_PRICE = 20000.0;
    static double BOTTOM_FEE = 1000.0;

    public static double getAdminFee(double price, double discount){
        if (getDiscountedPrice(price, discount) < BOTTOM_PRICE) { return BOTTOM_FEE; }
        else{
            return getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER;
        }
    }
    public static double getDiscountedPrice(double price, double discount){
        if (discount>100.0f){return 100.0f; }
        else if (discount == 100.0f) {return 0.0;}
        else{
            int x = (int)(price - (price * discount/100));
            return x;
        }
    }
    public static double getAdjustedPrice(double price, double discount) {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
}

