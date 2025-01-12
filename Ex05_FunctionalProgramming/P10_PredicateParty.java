package Ex05_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate;

        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Party!".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0]; // remove or double
            String criteria = tokens[1]; // start, end and lenght
            String parameter = tokens[2];

            switch (criteria) {
                case "StartsWith":
                    predicate = s -> s.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = s -> s.endsWith(parameter);
                    break;
                default:
                    predicate = s -> s.length() == Integer.parseInt(parameter);
                    break;
            }

            if ("Remove".equals(command)) {
                guest.removeIf(predicate);
            } else {
                List<String> guestToAdd = guest.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());

                guest.addAll(guestToAdd);
            }

            line = scanner.nextLine();
        }

        if (guest.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = guest.stream()
                    .sorted()
                    .collect(Collectors.joining(", "));
            System.out.println(result + " are going to the party!");
        }
    }
}
