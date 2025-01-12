package Ex03_SetsAndMapsAdvanced;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            //1. method -> collection
            //elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
            //2. method
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .forEach(elements::add);
        }

        String result = String.join(" ", elements);
        System.out.println(result);
    }
}
