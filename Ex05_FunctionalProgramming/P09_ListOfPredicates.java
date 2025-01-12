package Ex05_FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class P09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        BiPredicate<int[], Integer> match = (divisors, number) -> {
            for (int divisor : divisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        int number = Integer.parseInt(scanner.nextLine());
        int[] divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();

        for (int i = 1; i <= number; i++) {
            if (match.test(divisors, i)) {
                numbers.add(i);
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
