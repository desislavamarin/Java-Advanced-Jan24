package ExamPreparation;

import java.util.*;

public class P01_ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque();
        Deque<Double> cacaoStack = new ArrayDeque();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoStack::push);

        //създаваме map за видовете шоколад
        Map<String, Integer> chocolateMap = new LinkedHashMap<>();
        chocolateMap.put("Baking", 0);
        chocolateMap.put("Dark", 0);
        chocolateMap.put("Milk", 0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            //take first milk , take last cacao
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            //chocolate formula - (cacao / (milk + cacao)) * 100
            double chocolate = (cacao / (milk + cacao)) * 100;

            if (chocolate == 30) {
                chocolateMap.put("Milk" , chocolateMap.get("Milk") + 1);
            }else if (chocolate == 50) {
                chocolateMap.put("Dark" , chocolateMap.get("Dark") + 1);
            } else if (chocolate == 100) {
                chocolateMap.put("Baking" , chocolateMap.get("Baking") + 1);
            } else {
                milk += 10;
                milkQueue.offer(milk);
            }
        }

        long count = chocolateMap.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .count();
        if (count == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            chocolateMap.forEach((k,v) -> System.out.printf("# %s Chocolate --> %d%n", k, v));
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            chocolateMap.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() != 0)
                    .forEach(entry -> System.out.printf("# %s Chocolate --> %d%n",
                            entry.getKey(), entry.getValue()));
        }
    }
}
