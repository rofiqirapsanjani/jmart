package AchmadRofiqiRapsanjaniJmartRK;

public class Recognizable {
    // instance variables - replace the example below with your own
    public final int id;

    // constructor
    protected Recognizable(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof Recognizable) {
            Recognizable or = (Recognizable) o;
            if (this.id == or.id) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean equals(Recognizable r) {
        if (this.id == r.id) {
            return true;
        } else {
            return false;
        }
    }

}
