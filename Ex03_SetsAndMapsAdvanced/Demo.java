package Ex03_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //прочитаме от конзолата и въвеждаме в TreeSet
        Set<Integer> set = new TreeSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(set::add);

        //връща HashSet -> прочита и въвежда с една команда
        Set<Integer> collect = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        //Map<id, name>
        Map<Integer, String> map = new HashMap<>();
        //1. вариант за принтиране
        map.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        //2. вариант за принтиране
        map.forEach((k, v) -> System.out.println(k + " " + v));


    }
}
