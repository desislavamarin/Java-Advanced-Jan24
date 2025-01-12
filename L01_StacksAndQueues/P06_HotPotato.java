package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenNames = scanner.nextLine().split("\\s+");
        int count = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> names = new ArrayDeque<>();

        for (String name : childrenNames) {
            names.offer(name);
        }

        while (names.size() > 1) {
            for (int i = 1; i < count; i++) {
                names.offer(names.poll());
            }
            System.out.println("Removed " + names.poll());
        }
        System.out.println("Last is " + names.poll());
    }
}
