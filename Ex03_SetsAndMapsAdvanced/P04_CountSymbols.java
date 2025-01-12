package Ex03_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> characters = new TreeMap<>();

        for (Character ch : input.toCharArray()) {
            characters.putIfAbsent(ch, 0);
            int counter = characters.get(ch) + 1;
            characters.put(ch, counter);
        }
        characters.forEach((ch, count) ->
                System.out.println(String.format("%c: %d time/s", ch, count)));
    }
}
