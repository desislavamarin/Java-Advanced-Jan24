package Ex05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //sorts all even numbers before all odd ones in ascending order
        //comparator -> function accepts 2 parameters and return int(1, 0, -1)

        Comparator<Integer> customComparator = (first, second) -> {
            //first even, second odd -> not swap
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
                //first odd, second even -> swap
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            //first even, second even
            //first odd, second odd
            else {
               return first.compareTo(second);
            }
        };

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(e -> System.out.print(e + " "));
    }
}
