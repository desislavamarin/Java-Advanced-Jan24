package L03_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (Double num : input) {
            /*if (numbers.containsKey(num)) {
                int count = numbers.get(num);
                count++;
                numbers.put(num, count);
            } else {
                numbers.put(num, 1);
            }*/

            numbers.putIfAbsent(num, 0);
            int newCount = numbers.get(num) + 1;
            numbers.put(num, newCount);
        }

        numbers.forEach((k,v) -> {
            System.out.printf("%.1f -> %d%n", k, v);
        });
    }
}
