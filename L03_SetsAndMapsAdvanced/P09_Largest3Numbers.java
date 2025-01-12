package L03_SetsAndMapsAdvanced;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e)).sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3).collect(Collectors.toList());

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
