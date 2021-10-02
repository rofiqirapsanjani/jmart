package AchmadRofiqiRapsanjaniJmartRK;

import java.text.SimpleDateFormat;
import java.util.*;

public class Shipment implements FileParser {
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;

    // inner class Duration
    static class Duration {
        public static final Duration INSTANT = new Duration((byte) (1 << 0)); // 0000 0001
        public static final Duration SAME_DAY = new Duration((byte) (1 << 1)); // 0000 0010
        public static final Duration NEXT_DAY = new Duration((byte) (1 << 2)); // 0000 0100
        public static final Duration REGULER = new Duration((byte) (1 << 3)); // 0000 1000
        public static final Duration KARGO = new Duration((byte) (1 << 4)); // 0001 0000
        SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("'Formatted Date:' dd/MM/yyyy");
        public Calendar cal = Calendar.getInstance();
        String curDate = ESTIMATION_FORMAT.format(cal.getTime());

        public byte bit;

        private Duration(byte bit) {
            this.bit = bit;
        }

        public String getEstimatedArrival(Date reference) {
            if (bit == 00000001 | bit == 00000001) {
                return curDate;
            }
            if (bit == 00000100) {
                cal.add(Calendar.DATE, 1);
                String curDate = ESTIMATION_FORMAT.format(cal.getTime());
                return curDate;

            }
            if (bit == 00001000) {
                cal.add(Calendar.DATE, 2);
                String curDate = ESTIMATION_FORMAT.format(cal.getTime());
                return curDate;
            }
            if (bit == 00010000) {
                cal.add(Calendar.DATE, 5);
                String curDate = ESTIMATION_FORMAT.format(cal.getTime());
                return curDate;
            } else {
                return "null";
            }

        }
    }

    // inner class MultiDuration
    class MultiDuration {
        public byte bit;
        Calendar cal = Calendar.getInstance();

        public MultiDuration(Duration... args) {
            byte bits = 0;
            for (Duration arg : args) {
                bits |= arg.bit;
            }
            this.bit = bits;
        }

        public boolean isDuration(Duration reference) {
            if ((bit & reference.bit) != 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    // constructor
    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

}
