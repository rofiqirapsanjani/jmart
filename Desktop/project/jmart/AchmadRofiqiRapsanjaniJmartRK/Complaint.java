package AchmadRofiqiRapsanjaniJmartRK;

public class Complaint extends Recognizable implements FileParser {
    public int paymentId;
    public String desc;
    public String date = "20 08 2021";

    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;

    }

    @Override
    public boolean read() {
        // TODO Auto-generated method stub
        return false;
    }

}
