package AchmadRofiqiRapsanjaniJmartRK;

public interface Transactor {
    public enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }

    public boolean validate();

    public Invoice perform();

}