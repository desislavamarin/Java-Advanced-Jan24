package L04_StreamsFilesAndDirectories;

import java.io.File;

public class P07_ListFiles {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\output.txt";

        File f = new File("D:\\softuni\\Java Advanced\\resources\\Files-and-Streams");

        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if (!file.isDirectory()) {
                    System.out.println(file.getName() + ": [" + file.length() + "]");
                }
            }
        }
    }
}
