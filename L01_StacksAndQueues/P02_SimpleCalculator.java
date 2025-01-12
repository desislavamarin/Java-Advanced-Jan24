package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            stack.push(token);
        }

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            switch (operation) {
                case "+":
                    stack.push(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNumber - secondNumber));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
