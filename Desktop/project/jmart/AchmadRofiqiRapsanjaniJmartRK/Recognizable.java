package AchmadRofiqiRapsanjaniJmartRK;

public class Recognizable {
    public final int id;

    public Recognizable(int id) {
        this.id = id;
    }

    public boolean equals(Object other) {
        if (other instanceof Recognizable) {
            return true;

        }

        return false;

    }

    public boolean equals(Recognizable b, int id) {
        return false;

    }
}
