package Ex02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String [][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] commandParts = command.split("\\s+");

            //валидираме командата
            if (validateCommand(commandParts, rows, cols)) {
                int rowFirstElement = Integer.parseInt(commandParts[1]);
                int colFirstElement = Integer.parseInt(commandParts[2]);
                int rowSecondElement = Integer.parseInt(commandParts[3]);
                int colSecondElement = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[rowFirstElement][colFirstElement];
                String secondElement = matrix[rowSecondElement][colSecondElement];

                //размяна
                matrix[rowFirstElement][colFirstElement] = secondElement;
                matrix[rowSecondElement][colSecondElement] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    private static boolean validateCommand(String[] commandParts, int rows, int cols) {
        //брой части на командата
        if (commandParts.length != 5) {
            return false;
        }

        //започва с думата "swap"
        if (!"swap".equals(commandParts[0])) {
            return false;
        }

        //проверка дали редовете и колоните са валидни
        //елемента на първия ред -> >= 0 и < бр. редове
        //елемента на първата колона -> >= 0 и < бр. колони
        int rowFirstElement = Integer.parseInt(commandParts[1]);
        int colFirstElement = Integer.parseInt(commandParts[2]);
        int rowSecondElement = Integer.parseInt(commandParts[3]);
        int colSecondElement = Integer.parseInt(commandParts[4]);
        if (rowFirstElement >= 0 && rowFirstElement < rows && rowSecondElement >= 0 && rowSecondElement < rows
                && colFirstElement >= 0 && colFirstElement < cols && colSecondElement >= 0 && colSecondElement < cols) {
            //валидни редове и колони
            return true;
        } else {
            return false;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String [] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
