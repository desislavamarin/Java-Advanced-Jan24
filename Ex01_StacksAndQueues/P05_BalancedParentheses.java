package Ex01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // { [ ( ) ] } - примерен балансиран израз

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String result = isBalanced(input) ? "YES" : "NO";
        //въпросителни знак, извършва действието "ако"
        //ако върне "true" на "boolean-a -> тогава да принтира "YES"
        //ако върне "false" -> "NO"
        //двуточието - извършва действието "или"

        System.out.println(result);
    }

    private static boolean isBalanced(List<String> input) {
        ArrayDeque<String> openParanthesesStack = new ArrayDeque<>();
        for (String brace : input) {

            switch (brace) {
                case "}":
                    if (openParanthesesStack.isEmpty()) {
                        return false;
                    }
                    String openBrace = openParanthesesStack.pop();
                    if (!openBrace.equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    if (openParanthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParanthesesStack.pop();
                    if (!openBrace.equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    if (openParanthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParanthesesStack.pop();
                    if (!openBrace.equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openParanthesesStack.push(brace);
                    break;
            }
        }

        return openParanthesesStack.isEmpty();
    }
}
