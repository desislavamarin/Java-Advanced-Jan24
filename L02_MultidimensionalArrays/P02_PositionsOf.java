package L02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readInputArray(scanner);

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = readInputArray(scanner);
        }

        int number = Integer.parseInt(scanner.nextLine());

        boolean hasFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if ((matrix[row][col]) == number) {
                    System.out.printf("%d %d%n", row, col);
                    hasFound = true;
                }
            }
        }

        if (!hasFound) {
            System.out.println("not found");
        }
    }

    public static int[] readInputArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
