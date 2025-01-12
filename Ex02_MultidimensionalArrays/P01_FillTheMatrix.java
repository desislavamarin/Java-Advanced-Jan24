package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parameters = scanner.nextLine().split(", ");
        int dimm = Integer.parseInt(parameters[0]);
        String pattern = parameters[1];

        int[][] matrix = new int[dimm][dimm];

        switch (pattern) {
            case "A":
                fillPatterA(matrix);
                break;
            case "B":
                fillPatterB(matrix);
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }

    public static void fillPatterB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = matrix[col].length - 1 ; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }

    public static void fillPatterA(int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = count;
                count++;
            }
        }
    }
}
