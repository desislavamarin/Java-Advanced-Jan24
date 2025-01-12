package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] field = new String[rows][cols];

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                field[row][col] = currentRow[col];
                if ("B".equals(field[row][col])) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int boyRow = startRow;
        int boyCol = startCol;

        boolean isLeft = false;

        while (!isLeft) {

            if ("P".equals(field[boyRow][boyCol])) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                field[boyRow][boyCol] = "R";
            } else if ("-".equals(field[boyRow][boyCol])) {
                field[boyRow][boyCol] = ".";
            } else if ("A".equals(field[boyRow][boyCol])) {
                System.out.println("Pizza is delivered on time! Next order...");
                field[boyRow][boyCol] = "P";
                break;
            }

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (boyRow - 1 >= 0) {
                        if ("*".equals(field[boyRow-1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow--;
                    break;
                case "down":
                    if (boyRow + 1 < field.length) {
                        if ("*".equals(field[boyRow + 1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow++;
                    break;
                case "left":
                    if (boyCol - 1 >= 0) {
                        if ("*".equals(field[boyRow][boyCol - 1])) {
                            continue;
                        }
                    }
                    boyCol--;
                    break;
                case "right":
                    if (boyCol + 1 < cols) { //field[boyRow].length
                        if ("*".equals(field[boyRow][boyCol + 1])) {
                            continue;
                        }
                    }
                    boyCol++;
                    break;
            }

            isLeft = isOutOfTheField(field, boyRow, boyCol);
        }

        if (isLeft) {
            field[startRow][startCol] = " ";
            System.out.println("The delivery is late. Order is canceled.");
        }

        printField(field);
    }

    private static boolean isOutOfTheField(String[][] field, int boyRow, int boyCol) {
        return boyRow < 0 || boyRow >= field.length ||
                boyCol < 0 || boyCol >= field[boyRow].length;
    }

    private static void printField(String[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
