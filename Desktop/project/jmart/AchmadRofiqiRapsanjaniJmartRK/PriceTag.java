package AchmadRofiqiRapsanjaniJmartRK;



public class PriceTag {
    final double COMMISION_MULTIPLIER = 0.05;
    final double BOTTOM_PRICE = 200000.0;
    final double BOTTOM_FEE = 1000.0;
    double discount;
    double price;

    PriceTag(double price, double discount) {
        this.price = price;
        this.discount = discount;

    }

    PriceTag(double price) {
        this.price = price;
        this.discount = 0.0;

    }

    double getDiscountPrice() {
        if (discount > 100.0) {
            discount = 100.0;
        }
        if (discount == 100.0) {
            return 0.0;
        } else {
            return (price - (discount / 100) * price);
        }
    }

    double getAjustePrice() {
        return getDiscountPrice() + getAdminFee();
    }

    double getAdminFee() {
        if (getDiscountPrice() < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        } else {
            return getDiscountPrice() - getDiscountPrice() * COMMISION_MULTIPLIER;
        }
    }

}
