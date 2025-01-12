package Ex08_Generics;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }

}
