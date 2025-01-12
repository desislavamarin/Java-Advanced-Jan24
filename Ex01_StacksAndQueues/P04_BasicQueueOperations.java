package Ex01_StacksAndQueues;

import java.util.*;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countNumber = tokens[0];
        int popNumber = tokens[1];
        int containsNumber = tokens[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        for (int i = 0; i < popNumber; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(containsNumber)) {
            System.out.println(true);
        } else { //ако горните проверки не са верни -> правим проверка за най-малко число
            Integer smallestElement = Collections.min(queue);
            System.out.println(smallestElement);
        }
    }
}
