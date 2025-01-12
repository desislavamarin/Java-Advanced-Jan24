package Ex09_IteratorsandComparators.P05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            personList.add(person);

            line = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());

        Person person = personList.get(n - 1);
        personList.remove(person);
        int equals = 0;
        for (Person person1 : personList) {
            int res = person1.compareTo(person);
            if (res == 0) {
                equals++;
            }
        }

        if (equals == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equals + 1, personList.size() - equals, personList.size() + 1);
        }
    }
}
