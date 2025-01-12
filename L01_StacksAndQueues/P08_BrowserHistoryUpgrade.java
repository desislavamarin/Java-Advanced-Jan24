package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!"Home".equals(input)) {

            if ("back".equals(input)) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    String currentURL = browserHistory.pop();
                    forwardHistory.push(currentURL);
                    System.out.println(browserHistory.peek());
                }
            } else if ("forward".equals(input)) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currentForward = forwardHistory.pop();
                    System.out.println(currentForward);
                    browserHistory.push(currentForward);
                }
            } else {
                browserHistory.push(input);
                System.out.println(input);
                forwardHistory.clear();
            }
            input = scanner.nextLine();
        }
    }
}
