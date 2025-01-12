package L05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String, Integer> parser = x -> Integer.parseInt(x);

        List<Integer> numbers = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(parser)
                .collect(Collectors.toList());

        int count = numbers.size();
        int sum = numbers.stream().mapToInt(x -> x.intValue()).sum();

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);

        //друго решение
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        System.out.println("Count = " + intSummaryStatistics.getCount());
        System.out.println("Sum = " + intSummaryStatistics.getSum());
    }
}
