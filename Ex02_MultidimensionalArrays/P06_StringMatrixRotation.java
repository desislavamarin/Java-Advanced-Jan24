package Ex02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotation = Integer.parseInt(input.split("[()]+")[1]);
        int rotationAngle = rotation % 360;

        ArrayList<String> inputForMatrix = new ArrayList<>();
        int maxLenght = Integer.MIN_VALUE;

        String words = scanner.nextLine();

        while (!"END".equals(words)) {
            inputForMatrix.add(words);
            if (input.length() > maxLenght) {
                maxLenght = input.length();
            }

            words = scanner.nextLine();
        }

        int rows = inputForMatrix.size();
        int cols = maxLenght;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < inputForMatrix.get(row).length()) {
                    matrix[row][col] = inputForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        rotate(rotationAngle, rows, cols, matrix);
    }

    private static void rotate(int rotationAngle, int rows, int cols, char[][] matrix) {
        if (rotationAngle == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int row = rows - 1; row >= 0 ; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

}
