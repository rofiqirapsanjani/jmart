package AchmadRofiqiRapsanjaniJmartRK;
import  java.lang.Comparable;

public class Recognizable implements Comparable<Recognizable>
{
    // instance variables - replace the example below with your own
    final int id;

    protected Recognizable(int id){
        this.id = id;
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id){
        return 0;
    }
    public static <T extends Recognizable> int getClosingId(Class<T> Clazz, int id){
        return 0;
    }
    public boolean equals(Recognizable recognizable){
        return true;
    }

    public boolean equals(Object object) {
        if ((object instanceof Recognizable)){
            Recognizable recognizable = (Recognizable)object;
            if (recognizable.id == this.id){
                equals(recognizable);
            }else{return false;}
        }
        return false;
    }

    public int compareTo(Recognizable recognizable){
        if (recognizable.id == this.id) {
            return 1;
        }else{return 0;}
    }


}

