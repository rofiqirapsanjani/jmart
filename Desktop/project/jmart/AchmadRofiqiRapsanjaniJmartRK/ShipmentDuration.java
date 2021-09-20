package AchmadRofiqiRapsanjaniJmartRK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration {
    final byte INSTANT = 00000001;
    final byte SAME_DAY = 00000010;
    final byte NEXT_DAY = 00000100;
    final byte REGULAR = 00001000;
    final byte KARGO = 00010000;
    int bit;

    ShipmentDuration(int bit) {
        this.bit = bit;
    }

    ShipmentDuration(ShipmentDuration... args) {
        byte hasil = 00000000;
        for (int i : args) {
            hasil = hasil | i;
        }
    }

    boolean isDuration(ShipmentDuration reference) {

    }
}
