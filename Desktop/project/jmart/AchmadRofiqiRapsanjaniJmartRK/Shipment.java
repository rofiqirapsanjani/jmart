package AchmadRofiqiRapsanjaniJmartRK;

public class Shipment implements FileParser {
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }

    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

    public static class Duration {
        public static final Shipment INSTANT = new Shipment(1 << 0);
        public static final Shipment SAME_DAY = new Shipment(1 << 1);
        public static final Shipment NEXT_DAY = new Shipment(1 << 2);
        public static final Shipment REGULER = new Shipment(1 << 3);
        public static final Shipment KARGO = new Shipment(1 << 4);

        private final int bit;

        private Shipment(int bit) {
            this.bit = bit;
        }

        public Shipment(Shipment... args) {
            int flags = 0;
            for (Shipment arg : args)
                flags |= arg.bit;
            bit = flags;
        }

        public boolean isDuration(Shipment reference) {
            return (bit & reference.bit) != 0;
        }
    }

    public class MultiDuration {
        public byte bit;

        public MultiDuration() {

        }

        public boolean isDuration() {
            return false;
        }

    }
}
