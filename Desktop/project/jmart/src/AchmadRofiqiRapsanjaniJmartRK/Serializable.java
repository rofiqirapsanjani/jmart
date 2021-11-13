package AchmadRofiqiRapsanjaniJmartRK;
import  java.util.HashMap;
import java.util.Map;


public class Serializable implements Comparable<Serializable>
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    //constructor
    protected Serializable(){

        Integer counter = mapCounter.get(getClass());
        if(counter == null){
            counter = 0;
        }else{
            counter = counter + 1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    @Override
    public int compareTo(Serializable other){
        return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }

    public boolean equals(Object other){
        if(other instanceof Serializable){
            Serializable or = (Serializable) other;
            if(this.id == or.id){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    public boolean equals(Serializable other){
        if(this.id == other.id){
            return true;
        }else{
            return false;
        }
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> clazz){
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id){
        return mapCounter.put(clazz, id);
    }
}
