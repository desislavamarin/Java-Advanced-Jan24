package Ex02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 3;
        int cols = 4;

        //какво е матрица
        int[][] matrix = new int[rows][cols];
        
        //как се чете матрица
        //вариант 1 -> вложен for цикъл
        for (int row = 0; row < rows; row++) { //обхожда редовете
            for (int col = 0; col < cols; col++) { //обхожда колоните
                matrix[row][col] = scanner.nextInt();
            }
        }
        //вариант 2 -> streamAPI
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        //вариант 3 -> for loop
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        
        //как се отпечатва матрица
        //вариант 1 -> foreach
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        //вариант 2 -> for loop
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        //движения в матрицата
        //движения нагоре -> ред - 1
        //движение надолу -> ред + 1
        //движение на дясно -> колона + 1
        //движение на ляво -> колона - 1


        //валидиране на индекси
        //колона е валидна -> колона >= 0 и колона < брой колони
        //ред е валиден -> ред >= 0 и ред < брой редове
    }
}
