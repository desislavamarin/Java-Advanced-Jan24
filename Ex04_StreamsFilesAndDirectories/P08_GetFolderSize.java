package Ex04_StreamsFilesAndDirectories;

import java.io.File;

public class P08_GetFolderSize {
    public static void main(String[] args) {

        String path = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);

        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                size += file.length();
            }
        }
        System.out.println("Folder size: " + size);
    }
}
