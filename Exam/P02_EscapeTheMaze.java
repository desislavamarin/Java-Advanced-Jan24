package Exam;

import java.util.Scanner;

public class P02_EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] maze = new String[n][n];

        int travellerRow = -1;
        int travellerCol = -1;

        for (int row = 0; row < maze.length; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                maze[row][col] = currentRow[col];

                if ("P".equals(maze[row][col])) {
                    travellerRow = row;
                    travellerCol = col;
                }
            }
        }
        
        int currentRow = travellerRow;
        int currentCol = travellerCol;

        boolean isLeft = false;
        int health = 100;

        while (!isLeft) {

            if ("M".equals(maze[currentRow][currentCol])) {
                health -= 40;
                if (health <= 0) {
                    health = 0;
                    System.out.println("Player is dead. Maze over!");
                    System.out.printf("Player's health: %d units", health);
                    break;
                } else {
                    maze[currentRow][currentCol] = "-";
                }
            } else if ("H".equals(maze[currentRow][currentCol])) {
                health += 15;
                if (health > 100) {
                    health = 100;
                }
                maze[currentRow][currentCol] = "-";
            } else if ("X".equals(maze[currentRow][currentCol])) {
                maze[currentRow][currentCol] = "-";
                break;
            }


            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        if ("-".equals(maze[currentRow-1][currentCol])) {
                            continue;
                        }
                    }
                    currentRow--;
                    break;
                case "down":
                    if (currentRow + 1 < maze.length) {
                        if ("-".equals(maze[currentRow + 1][currentCol])) {
                            continue;
                        }
                    }
                    currentRow++;
                    break;
                case "right":
                    if (currentRow + 1 < currentCol) { //field[boyRow].length
                        if ("-".equals(maze[currentRow][currentCol + 1])) {
                            continue;
                        }
                    }
                    currentCol--;
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                        if ("-".equals(maze[currentRow][currentCol - 1])) {
                            continue;
                        }
                    }
                    currentCol++;
                    break;
            }

            isLeft = isOutOfTheMaze(maze, currentRow, currentCol);

        }

        if (isLeft) {
            maze[currentRow][currentCol] = " ";
            System.out.println("Player escaped the maze. Danger passed!");
            System.out.printf("Player's health: %d units", health);
        }

        printMaze(maze);

    }

    private static boolean isOutOfTheMaze(String[][] maze, int currentRow, int currentCol) {
        return currentRow < 0 || currentRow >= maze.length ||
                currentCol < 0 || currentCol >= maze[currentRow].length;
    }

    private static void printMaze(String[][] maze) {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
    }
}
