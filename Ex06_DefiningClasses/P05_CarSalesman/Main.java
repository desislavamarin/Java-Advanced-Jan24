package Ex06_DefiningClasses.P05_CarSalesman;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();
    private static Map<String, Engine> engineMap = new LinkedHashMap<>();
    public static void main(String[] args) {

        getEngines();
        getCars();

        cars.forEach(System.out::println);
    }

    private static void getCars() {
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);
            switch (tokens.length) {
                case 2:
                    cars.add(new Car(model, engine));
                    break;
                case 3:
                    cars.add(new Car(model, engine, tokens[2]));
                    break;
                case 4:
                    cars.add(new Car(model, engine, tokens[2], tokens[3]));
                    break;
            }
        }
    }

    private static void getEngines() {
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            switch (tokens.length) {
                case 2:
                    engineMap.put(model, new Engine(model, power));
                    break;
                case 3:
                    engineMap.put(model, new Engine(model, power, tokens[2]));
                    break;
                case 4:
                    engineMap.put(model, new Engine(model, power, tokens[2], tokens[3]));
                    break;

            }
        }
    }
}
