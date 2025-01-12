package L08_Generics;

import java.util.List;

public class ListUtils<T extends Comparable<T>> {
    public static <T extends Comparable<T>> T getMin(List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arr.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arr.stream().max(Comparable::compareTo).get();
    }
}
