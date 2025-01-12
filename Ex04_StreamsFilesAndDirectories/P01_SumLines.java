package Ex04_StreamsFilesAndDirectories;

import java.io.*;

public class P01_SumLines {
    public static void main(String[] args) {

        String path = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    sum += symbol;
                }
                System.out.println(sum);

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
