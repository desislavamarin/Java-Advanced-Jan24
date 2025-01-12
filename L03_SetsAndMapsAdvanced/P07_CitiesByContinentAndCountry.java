package L03_SetsAndMapsAdvanced;

import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);

        }

        for (String continents : map.keySet()) {
            System.out.println(continents + ":");
            LinkedHashMap<String, List<String>> countries = map.get(continents);
            for (String country : countries.keySet()) {
                System.out.print(country + " -> ");
                System.out.println(String.join(", ", countries.get(country)));
            }
        }
    }
}
