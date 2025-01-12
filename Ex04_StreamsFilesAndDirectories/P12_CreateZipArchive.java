package Ex04_StreamsFilesAndDirectories;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12_CreateZipArchive {
    public static void main(String[] args) {

        String inputPath1 = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String inputPath2 = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPath3 = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(inputPath1, inputPath2, inputPath3);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)
                ) {

            for (String path : paths) {
                File file = new File(path);
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());

                zipOutputStream.putNextEntry(zipEntry);
                int oneByte = fileInputStream.read();

                while (oneByte != -1) {
                    zipOutputStream.write(oneByte);

                    oneByte = fileInputStream.read();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
