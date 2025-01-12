package Ex03_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextLine());
        }

        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextLine());
        }

        //1. method with filter
        firstSet.stream()
                .filter(secondSet::contains)
                .forEach(e -> System.out.print(e + " "));

        //2. retain method
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));

        //3. check which set is smallest
        if (firstSet.size() <= secondSet.size()){
            //then iterate the smallest set
            for (String s : firstSet) {
                if (secondSet.contains(s)) {
                    System.out.print(s + " ");
                }
            }
        } else {
            for (String s : secondSet) {
                if (firstSet.contains(s)) {
                    System.out.print(s + " ");
                }
            }
        }
    }
}
