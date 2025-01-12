package L01_StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        // 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if ('(' == current) {
                stack.push(i);
            } else if (')' == current) {
                int startIndex = stack.pop();
                String match = input.substring(startIndex, i + 1);
                System.out.println(match);
            }
        }
    }
}
