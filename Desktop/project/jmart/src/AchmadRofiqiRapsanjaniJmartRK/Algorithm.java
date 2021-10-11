package AchmadRofiqiRapsanjaniJmartRK;
import  java.util.*;
public class Algorithm {
    private Algorithm(){

    }
    public static <T>int count(T[] array, T value){
        int counter = 0;
        for(T arrayValue : array){

            if (arrayValue.equals(value)){
                counter++;
            }
        }
        return counter;
    }
    public static <T>int count(Iterable<T> iterable, T value){
        int counter = 0;
        for(T t : iterable){
            if(t.equals(value)){
                counter++;
            }
        }
        return counter;
    }
    public static <T>int count(Iterator<T> iterator, T value){
        int counter = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                counter++;
            }
        }
        return counter;
    }

    public static <T> boolean exists(T[] array, T value)
    {
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value)
    {
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value)
    {
        return false;
    }

    public static <T> boolean exists(T [] array, Predicate<T> pred)
    {
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
    {
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterable, Predicate<T> pred)
    {
        return false;
    }

    public static <T>T find(T[] array, T value){
        return null;
    }
    public static <T>T find(Iterable<T> iterable, T value){
        return null;
    }
    public static <T>T find(Iterator<T> iterator, T value){
        return  null;
    }
    public static <T>T find(T[] array, Predicate<T> pred){
        return null;
    }
    public static <T>T find(Iterable<T> iterable, Predicate<T> pred){
        return null;
    }
    public static <T>T find(Iterator<T> iterator, Predicate<T> pred){
        return  null;
    }

    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> iterate = Arrays.stream(array).iterator();
        return collect(iterate, value);
    }
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for(T t : iterable){
            if(t.equals(value)){
                list.add(t);
            }
        }
        return list;
    }
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> iterate = Arrays.stream(array).iterator();
        return collect(iterate, pred);
    }
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> iterate = iterable.iterator();
        return collect(iterate, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        return collect(iterator, pred);
    }
    public static <T extends Comparable<? super T>>T max(T first, T second){
        if((first.compareTo(second))>0){
            return first;
        }else{
            return second;
        }
    }
    public static <T extends Comparable<? super T>>T max(T[] array){
     return  null;
    }
    public static <T extends Comparable<? super T>>T max(Iterable<T> iterable){
        return  null;
    }
    public static <T extends Comparable<? super T>>T max(Iterator<T> iterator){
        return null;
    }
    public static <T extends Comparable<? super T>>T max(T first, T second, Comparator<? super T> comparator){
        if(comparator.compare(first, second) > 0){
            return first;
        }else{
            return second;
        }
    }
    public static <T extends Comparable<? super T>>T max(T[] array, Comparator<? super T> comparator){
        T maximum = array[0];
        for(T t : array){
            if(comparator.compare(t, maximum) > 0){
                maximum = t;
            }
        }
        return maximum;
    }

    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
        T maximum = iterable.iterator().next();
        for (T t : iterable) {
            if (comparator.compare(t, maximum) > 0) {
                maximum = t;
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
        T maximum = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (comparator.compare(t, maximum) > 0) {
                maximum = t;
            }
        }
        return maximum;
    }







    public static <T extends Comparable<? super T>>T min(T first, T second){
        if((first.compareTo(second))>0){
            return second;
        }else{
            return first;
        }
    }
    public static <T extends Comparable<? super T>>T min(T[] array){
        return  null;

    }
    public static <T extends Comparable<? super T>>T min(Iterable<T> iterable){

        return  null;
    }
    public static <T extends Comparable<? super T>>T min(Iterator<T> iterator) {
        return  null;
    }
    public static <T extends Comparable<? super T>>T min(T first, T second, Comparator<? super T> comparator){
        if(comparator.compare(first, second) > 0){
            return second;
        }else{
            return first;
        }
    }
    public static <T extends Comparable<? super T>>T min(T[] array, Comparator<? super T> comparator){
        T minimum = array[0];
        for(T t : array){
            if(comparator.compare(t, minimum) < 0){
                minimum = t;
            }
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        T minimum = iterable.iterator().next();
        for (T t : iterable) {
            if (comparator.compare(t, minimum) < 0) {
                minimum = t;
            }
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        T minimum = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (comparator.compare(t, minimum) < 0) {
                minimum = t;
            }
        }
        return minimum;
    }



}
