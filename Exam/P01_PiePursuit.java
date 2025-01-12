package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> piecesConsumptionQueue = new ArrayDeque();
        Deque<Integer> piePiecesStack = new ArrayDeque();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(piecesConsumptionQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(piePiecesStack::push);

        while (!piecesConsumptionQueue.isEmpty() && !piePiecesStack.isEmpty()) {
            int contestantCapacity = piecesConsumptionQueue.poll();
            int pieSize = piePiecesStack.pop();

            if (contestantCapacity >= pieSize) {
                contestantCapacity -= pieSize;
                if (contestantCapacity > 0) {
                    piecesConsumptionQueue.offer(contestantCapacity);
                }
            } else {
                pieSize -= contestantCapacity;
               if (piePiecesStack.size() > 0) {
                   int nextPie = piePiecesStack.pop();
                   piePiecesStack.push(nextPie + pieSize);
               } else {
                   piePiecesStack.push(pieSize);
               }
            }
        }


        if (piePiecesStack.isEmpty() && piecesConsumptionQueue.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (piePiecesStack.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            while (!piecesConsumptionQueue.isEmpty()) {
                System.out.printf("%d", piecesConsumptionQueue.poll());
                if (!piecesConsumptionQueue.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.printf("%n");
        } else if (piecesConsumptionQueue.isEmpty()) {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            while (!piePiecesStack.isEmpty()) {
                System.out.printf("%d", piePiecesStack.pop());
                if (!piePiecesStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.printf("%n");
        }
    }
}
