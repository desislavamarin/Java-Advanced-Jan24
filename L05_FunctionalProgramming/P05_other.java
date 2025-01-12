package L05_FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_other {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split(",\\s+");
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiFunction<Integer, String, Predicate<Integer>> filter = (ag, con) -> {
            if ("younger".equals(con)) {
                return a -> a <= ag;
            }
            return a -> a >= ag;
        };

        Function<String, Consumer<Map.Entry<String, Integer>>> consumerFactor = a -> {
            switch (a) {
               case "name":
                    return m -> System.out.println(m.getKey());
                case "age" :
                    return m -> System.out.println(m.getValue());
                default:
                    return m -> System.out.println(m.getKey() + " - " + m.getValue());
            }
        };

        people.entrySet().stream()
                .filter(e -> filter.apply(age, condition).test(e.getValue()))
                .forEach(e -> consumerFactor.apply(format).accept(e));
    }
}
