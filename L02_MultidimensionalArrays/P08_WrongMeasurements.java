package L02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] inputMatrix = new int[size][];

        for (int row = 0; row < size; row++) {
            inputMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] coordinates = scanner.nextLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        int wrongValue = inputMatrix[x][y];

        int[][] resultMatrix = new int[size][];

        for (int row = 0; row < size; row++) {
            resultMatrix[row] = inputMatrix[row].clone();
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (resultMatrix[row][col] == wrongValue) {
                    resultMatrix[row][col] = getSum(inputMatrix, row, col, wrongValue);
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] inputMatrix, int row, int col, int wrongValue) {
        int sum = 0;
        if (row - 1 >= 0 && inputMatrix[row - 1][col] != wrongValue) {
            sum += inputMatrix[row - 1][col];
        }
        if (row + 1 < inputMatrix.length && inputMatrix[row + 1][col] != wrongValue) {
            sum += inputMatrix[row + 1][col];
        }
        if (col - 1 >= 0 && inputMatrix[row][col - 1] != wrongValue) {
            sum += inputMatrix[row][col - 1];
        }
        if (col + 1 < inputMatrix[row].length && inputMatrix[row][col + 1] != wrongValue) {
            sum += inputMatrix[row][col + 1];
        }

        return sum;
    }
}
