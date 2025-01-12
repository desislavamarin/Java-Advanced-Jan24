package Ex04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09_CopyAPicture {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\3 (8).jpg";
        String outputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\copy(8).jpg";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {
                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
