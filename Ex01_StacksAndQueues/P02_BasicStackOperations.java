package Ex01_StacksAndQueues;

import java.util.*;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        //прочитаме елементите от конзолата и ги въвеждаме в масив
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int countNumber = tokens[0];
        int popNumber = tokens[1];
        int containsNumber = tokens[2];

        //прочитаме елементите от конзолата и ги въвеждаме направо в стек-а
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        for (int i = 0; i < popNumber; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(containsNumber)) {
            System.out.println(true);
        } else { //ако горните проверки не са верни -> правим проверка за най-малко число
            Integer smallestElement = Collections.min(stack);
            System.out.println(smallestElement);
        }
    }
}
