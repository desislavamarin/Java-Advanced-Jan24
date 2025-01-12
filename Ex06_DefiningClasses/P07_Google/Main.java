package Ex06_DefiningClasses.P07_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            people.putIfAbsent(name, new Person(name));

            Person person = people.get(name);
            String command = tokens[1];
            switch (command) {
                case "company":
                    person.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "pokemon":
                    person.add(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    person.add(new Parent(tokens[2], tokens[3]));
                    break;
                case "children":
                    person.add(new Child(tokens[2], tokens[3]));
                    break;
                case "car":
                    person.setCar(new Car(tokens[2], tokens[3]));
                    break;
            }

            input = scanner.nextLine();
        }

        String personName = scanner.nextLine();

        if (people.containsKey(personName)) {
            System.out.println(people.get(personName));
        }
    }
}
