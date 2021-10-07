
package AchmadRofiqiRapsanjaniJmartRK;

import java.util.Date;

public class Complaint extends Recognizable implements FileParser {
    public Date date = new Date();
    public String desc;

    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;
    }

    @Override
    public boolean read(String content) {
        return false;
    }

    public String toString() {
        date.getTime();
        return ("date=" + date + ", desc=" + desc);
    }

}
