package Ex04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02_SumBytes {
    public static void main(String[] args) {

        String path = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try(BufferedReader bf = Files.newBufferedReader(Paths.get(path))) {

            String line = bf.readLine();
            int sum = 0;

            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = bf.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
