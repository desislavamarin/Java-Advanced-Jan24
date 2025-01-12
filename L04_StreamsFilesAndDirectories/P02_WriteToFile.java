package L04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P02_WriteToFile {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\02.WriteToFileOutput.txt";

        Character[] chars = {',', '.', '!', '?'};
        Set<Character> pun = new HashSet<>(List.of(chars));
        //друг вариант е чрез List -> но там е по-бавно действието на кода

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);) {
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                char ch = (char)oneByte;
                if (!pun.contains(ch)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
