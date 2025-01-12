package Ex05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallestNumber = Collections::min;
        BiFunction<List<Integer>, Integer, Integer> getIndex = List::lastIndexOf;

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallestNumber = findSmallestNumber.apply(numbers);
        int index = getIndex.apply(numbers, smallestNumber);
        System.out.println(index);

    }
}
