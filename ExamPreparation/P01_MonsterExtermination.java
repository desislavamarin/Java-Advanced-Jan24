package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01_MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monsterQueue = new ArrayDeque<>();
        Deque<Integer> soldersStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(monsterQueue::offer);

        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(soldersStack::push);

        int killedMonster = 0;

        while (!monsterQueue.isEmpty() && !soldersStack.isEmpty()) {
            int armor = monsterQueue.poll();
            int strike = soldersStack.pop();

            if (strike >= armor) {
                killedMonster++;
                strike -= armor;
                if (soldersStack.size() > 0) {
                    int nextStrike = soldersStack.pop();
                    soldersStack.push(nextStrike + strike);
                } else {
                    if (strike > 0) {
                        soldersStack.push(strike);
                    }
                }
            } else {
                armor -= strike;
                monsterQueue.offer(armor);
            }
        }

        if (monsterQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (soldersStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonster);
    }
}
