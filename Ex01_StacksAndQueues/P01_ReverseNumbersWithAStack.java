package Ex01_StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");

        for (String element : input) { //добавяме елементите в stack-a
            int number = Integer.parseInt(element);
            stack.push(number);
        }

        /*Array.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);*/

        while (!stack.isEmpty()) { //премахваме елементите
            System.out.print(stack.pop() + " ");
        }
    }
}
