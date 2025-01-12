package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> swordTable = new HashMap<>();
        swordTable.put(70,"Gladius");
        swordTable.put(80,"Shamshir");
        swordTable.put(90,"Katana");
        swordTable.put(110,"Sabre");

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);

        Map<String, Integer> forgedSword = new TreeMap<>();
        //ако Map-a трябва да се нареди по размера на стойностите
        //forgedSword.entrySet().stream().sorted((a,b) -> a.getValue().compareTo(b.getValue()));

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            Integer steel = steelQueue.poll();
            Integer carbon = carbonStack.pop();
            Integer forgedValue = steel + carbon;

            if (swordTable.containsKey(forgedValue)) {
                String sword = swordTable.get(forgedValue);
                forgedSword.putIfAbsent(sword, 0);
                forgedSword.put(sword, forgedSword.get(sword) + 1);
            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        if (forgedSword.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
            printDeque(steelQueue, "Steel left: %s%n");
            printDeque(carbonStack, "Carbon left: %s%n");
        } else {
            //принтиране броя на стойностите в Map-a
            System.out.printf("You have forged %d swords.%n", forgedSword.values().stream()
                    .mapToInt(e -> e)
                    .sum());
            printDeque(steelQueue, "Steel left: %s%n");
            printDeque(carbonStack, "Carbon left: %s%n");
            forgedSword.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    public static void printDeque(Deque<Integer> deque, String format) {
        System.out.printf(format, deque.isEmpty() ? "none" :
                deque.stream().map(String::valueOf)
                        .collect(Collectors.joining(", ")));
    }
}
