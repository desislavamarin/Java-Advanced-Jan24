package L01_StacksAndQueues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenNames = scanner.nextLine().split("\\s+");
        int count = Integer.valueOf(scanner.nextLine());

        PriorityQueue<String> names = new PriorityQueue<>();

        for (String name : childrenNames) {
            names.offer(name);
        }

        int cycle = 1;
        while (names.size() > 1) {
            for (int i = 1; i < count; i++) {
                names.offer(names.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + names.poll());
    }

    private static boolean isPrime(int cycle) {
        boolean isPrime = true;
        for (int i = 2; i < cycle - 1; i++) {
            if (cycle % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (cycle == 1) {
            return false;
        }
        return isPrime;
    }

}
