package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filenames = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"print".equals(filenames)) {

            if ("cancel".equals(filenames)) {

                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }

            } else {
                queue.offer(filenames);
            }

            filenames = scanner.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
