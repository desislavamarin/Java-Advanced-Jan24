package L04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P03_CopyBytes {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\03.CopyBytesOutput.txt";

        Character[] chars = {',', '.', '!', '?'};
        Set<Character> pun = new HashSet<>(List.of(chars));
        //друг вариант е чрез List -> но там е по-бавно действието на кода

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);) {
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                // \r\n -> проверка за нов ред (new line) или space
                if (oneByte == 10 || oneByte == 32) {
                    fileOutputStream.write(oneByte);
                    oneByte = fileInputStream.read();
                    continue;
                }
                String data = String.valueOf(oneByte);
                for (char c : data.toCharArray()) {
                    fileOutputStream.write(c);
                }

                oneByte = fileInputStream.read();
            }
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
