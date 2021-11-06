package AchmadRofiqiRapsanjaniJmartRK;
import  java.util.HashMap;
import java.util.Map;


public class Serializable implements Comparable<Serializable>
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter;


    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter = 0;
        }else{
            counter = counter + 1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;

    }

    public int compareTo(Serializable other){

        return Integer.compare(this.id, other.id);
    }


    public boolean equals(Object other)
    {
        if ((other instanceof Serializable)){
            Serializable serializable = (Serializable)other;
            if (serializable.id == this.id){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean equals(Serializable other)
    {
        if(other.id == this.id){
            return true;
        }else{
            return true;
        }
    }


    public static <T extends Serializable> int getClosingId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }
    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id) {

        return mapCounter.getOrDefault(clazz, id);
    }
}