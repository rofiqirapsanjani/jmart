package AchmadRofiqiRapsanjaniJmartRK;

public interface FileParser {

    default Object write(String content) {
        return null;
    }

    default Object newInstance(String content) {
        return null;
    }

    boolean read();

}
