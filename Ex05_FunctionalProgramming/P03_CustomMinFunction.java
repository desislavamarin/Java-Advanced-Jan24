package Ex05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> getNumber =
                arr -> Arrays.stream(arr).min(Integer::compareTo).get();

        /*Function<Integer[], Integer> findNumber =
                arr -> {
            int minNumber = Integer.MAX_VALUE;
                    for (int number : arr) {
                        if (minNumber > number) {
                            minNumber = number;
                        }
                    }
                    return  minNumber;
                };*/

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(getNumber.apply(numbers));
    }
}
