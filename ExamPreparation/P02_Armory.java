package ExamPreparation;

import java.util.Scanner;

public class P02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] armoury = new String[n][n];

        int officerRow = -1;
        int officerCol = -1;

        for (int row = 0; row < armoury.length; row++) {
            String[] currentRow = scanner.nextLine().split("");
            // currentRow.length / armoury.length - ако матрицата е правоъгълна / или всеки ред е различен
            // n / armoury[row].length - ако матрицата е квадрата
            for (int col = 0; col < currentRow.length; col++) {
                armoury[row][col] = currentRow[col]; // така пълним матрицата

                if ("A".equals(armoury[row][col])) {
                    officerRow = row;
                    officerCol = col;
                }
            }
        }

        armoury[officerRow][officerCol] = "-";

        int goldCoins = 0;

        while (goldCoins < 65) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            //ако командата ни е изкарала от матрицата
            if (isOutOfTheArmoury(armoury, officerRow, officerCol)) {
                //ако сме извън полето - break
                break;
            }

            //опции върху които стъпваме:
            //"М" - teleport to the other "M", Digit-Sword - buy sword, "-" - do nothing
            //на стъпилите позиции после слагаме "-"
            //на текущата позиция, където стои офицера - поставяме "А"
            String officerPosition = armoury[officerRow][officerCol];
            armoury[officerRow][officerCol] = "-";
            if ("M".equals(officerPosition)) {
                //намираме коодинатите на другото огледало "М"
                int[] mirrorCoordinates = findMirrorCoordinates(armoury);

                int mirrorRow = mirrorCoordinates[0];
                int mirrorCol = mirrorCoordinates[1];

                //преместваме офицера
                officerRow = mirrorRow;
                officerCol = mirrorCol;

                //зачистваме
                armoury[officerRow][officerCol] = "-";

            } else if (!"-".equals(officerPosition)) {
                goldCoins += Integer.parseInt(officerPosition);
            }
        }


        if (goldCoins >= 65) {
            armoury[officerRow][officerCol] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n", goldCoins);

        print(armoury);
    }

    private static int[] findMirrorCoordinates(String[][] armoury) {
        int[] coordinates = new int[2];

        for (int row = 0; row < armoury.length; row++) {
            for (int col = 0; col < armoury[row].length; col++) {
                if ("M".equals(armoury[row][col])) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }

    private static boolean isOutOfTheArmoury(String[][] armoury, int officerRow, int officerCol) {
        //проверяване - когато редовете са < 0 и колоните са >= на дължината на матрицата
        return officerRow < 0 || officerRow >= armoury.length ||
                // само armoury - ако е квадратна
                officerCol < 0 || officerCol >= armoury[officerRow].length;
    }


    private static void print(String[][] armoury) {
        //принтиране на матрицата
        for (int row = 0; row < armoury.length; row++) {
            for (int col = 0; col < armoury[row].length; col++) {
                System.out.print(armoury[row][col]);
            }
            System.out.println();
        }
    }
}
