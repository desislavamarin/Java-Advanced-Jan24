package Ex06_DefiningClasses.P06_PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] inputData = input.split("\\s+");
            String trainer = inputData[0];
            String pokemonName = inputData[1];
            String element = inputData[2];
            int health = Integer.parseInt(inputData[3]);

            trainers.putIfAbsent(trainer, new Trainer(trainer));
            trainers.get(trainer).add(new Pokemon(pokemonName, element, health));

            input = scanner.nextLine();
        }

        String data = scanner.nextLine();
        while (!"End".equals(data)) {
            String element = data;
            trainers.values().forEach(trainer -> trainer.processElement(element));

            data = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted(Trainer::compareTo)
                .forEach(System.out::println);
    }
}
