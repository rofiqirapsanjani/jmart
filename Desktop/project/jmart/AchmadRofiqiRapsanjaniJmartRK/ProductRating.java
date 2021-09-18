package AchmadRofiqiRapsanjaniJmartRK;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating {
    long total;
    long count;

    ProductRating() {
        total = 0;
        count = 0;
    }

    void insert(int rating) {
        total = total + rating;
        count++;
    }

    double getAverage() {
        return getCount() / getTotal();
    }

    long getCount() {
        return count;
    }

    long getTotal() {
        return total;
    }
}

