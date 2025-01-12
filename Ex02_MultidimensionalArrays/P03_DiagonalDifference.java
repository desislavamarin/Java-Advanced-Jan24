package Ex02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове и колони
        int [][] matrix = new int[n][n];

        //напълваме матрицата
        fillMatrix(matrix, scanner);

        //сумата от числата на главния диагонал
        int sumPrimaryDiagonal = getSumElementsOnPrimaryDiagonal(matrix);
        //сума от числата на второстепенния диагонал
        int sumSecondaryDiagonal = getSumElementsOnSecondaryDiagonal(matrix);
        //принтиране на абсолютната стойност на разликата от двете суми
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumElementsOnSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        //всички елементи от матрицата -> сумират се тези, който са на второстепенния диагонал
        //(колона = общ брой редове - ред - 1)
        //ред + колона = общ брой редове - 1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                //проверяваме дали е на второстепенния диагонал
                if (col == matrix.length - row - 1) {
                    //елемента е на главния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int[][] matrix) {
        int sum = 0; //сума от числата на главния диагонал
        //всички елементи от матрицата -> сумират се тези, който са на главния диагонал (ред == колона)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                //проверяваме дали е на главния диагонал
                if (row == col) {
                    //елемента е на главния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        int rows = matrix.length; //брой редове = брой колони
        for (int row = 0; row < rows; row++) { //обхожда редовете
            for (int col = 0; col < rows; col++) { //обхожда колоните
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
