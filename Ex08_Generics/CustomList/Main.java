package Ex08_Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    customList.contains(tokens[1]);
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    customList.countGreaterThan(tokens[1]);
                    break;
                case "Max":
                    customList.getMax();
                    break;
                case "Min":
                    customList.getMin();
                    break;
                case "Print":
                    customList.forEach(System.out::println);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
