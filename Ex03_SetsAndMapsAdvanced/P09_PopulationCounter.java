package Ex03_SetsAndMapsAdvanced;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        while (!"report".equals(input)) {
            String[] inputData = input.split("\\|");
            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countriesTotalPopulation.putIfAbsent(country, 0L);
            Long currentPopulation = countriesTotalPopulation.get(country);
            countriesTotalPopulation.put(country, currentPopulation + population);
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countriesTotalPopulation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n",
                            entry.getKey(), entry.getValue());
                    countries.get(entry.getKey())
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach((pair) -> {
                                System.out.printf("=>%s: %d%n", pair.getKey(), pair.getValue());
                            });
                });
    }

    //метод чрез обекти
    static class Country {
        private String name;
        private Map<String, Long> cities;
        public Country(String name) {
            this.name = name;
            this.cities = new LinkedHashMap<>();
        }

        public long getTotalPopulation(){
            long totalPopulation = 0;
            for (Long population : cities.values()) {
                totalPopulation += population;
            }
            return totalPopulation;
        }

        public String toString() {
            //TODO implement proper toString method
            return "Country{" +
                    "name='" + name + '\'' +
                    ", cities=" + cities +
                    '}';
        }
    }
}
