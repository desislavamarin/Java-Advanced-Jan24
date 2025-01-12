package Ex05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenghtWord = Integer.parseInt(scanner.nextLine());

        Predicate<String> namesSmallerThanN = s -> s.length() <= lenghtWord;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(namesSmallerThanN)
                .forEach(System.out::println);

    }
}
