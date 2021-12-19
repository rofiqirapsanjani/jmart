package com.AchmadRofiqiRapsanjaniJmartRK;

import java.util.ArrayList;

public class Filter {
    // instance variables - replace the example below with your own
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {
        ArrayList<PriceTag> Pricetag = new ArrayList<>();
        for (PriceTag pricetag : list) {
            if ((less == true && pricetag.getAdjustedPrice() < value)) {
                Pricetag.add(pricetag);
            } else if ((less == false && pricetag.getAdjustedPrice() >= value)) {
                Pricetag.add(pricetag);
            }
        }
        return Pricetag;
    }

    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {
        for (int i = 0; i < list.size(); ++i) {
            final ProductRating productrating = list.get(i);
            if ((less == true && productrating.getAverage() < value)) {
                list.remove(i);
            } else if ((less == false && productrating.getAverage() >= value)) {
                list.remove(i);
            }
        }
    }

}
