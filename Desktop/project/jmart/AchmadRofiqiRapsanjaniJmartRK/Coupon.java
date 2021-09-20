package AchmadRofiqiRapsanjaniJmartRK;

/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon {
    String name;
    int code;
    double cut;
    Type type;
    double minimum;
    boolean used;

    Coupon(String name, int code, Type type, double cut, double minimun) {
        used = false;
    }

    boolean isUsed() {
        return used;
    }

    boolean canApply(PriceTag priceTag) {
        if ((PriceTag.getAjustedPrice() >= minimum) && used == false) {
            return true;
        } else {
            return false;
        }
    }

    double apply(PriceTag priceTag) {
        used = true;
        priceTag = PriceTag.getAjustedPrice() - cut;
        return priceTag;
    }

}
