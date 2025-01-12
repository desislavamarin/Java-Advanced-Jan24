package Ex02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        //print first part
        for (int c = cols - 1; c > 0; c--) {
            //за всеки един диагонал от долната половина на матрицата
            for (int row = rows - 1, col = c; row >=0 && col < cols; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


        //print second part
        for (int r = rows - 1; r >= 0; r--) {
            for (int col = 0, row = r; row >=0 && col < cols ; col++, row--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
