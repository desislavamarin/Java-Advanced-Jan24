package L04_StreamsFilesAndDirectories;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P04_ExtractIntegers {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\04.ExtractIntegersOutput.txt";

        try (FileReader fileReader = new FileReader(inputPath);) {
            FileWriter fileWriter = new FileWriter(outputPath);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }

        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
