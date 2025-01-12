package L04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class P01_ReadFile {
    public static void main(String[] args) {

        String path = "D:\\softuni\\Java Advanced\\Files-and-Streams\\input.txt"; //поставяме абсолютния път на файла

        try (FileInputStream fileStream = new FileInputStream(path);) {

            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileStream.read();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }
}
