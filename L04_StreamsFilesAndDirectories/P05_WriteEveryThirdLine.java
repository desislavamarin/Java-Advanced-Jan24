package L04_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\05.WriteEveryThirdLineOutput.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));

        for (int i = 0; i < inputData.size(); i++) {
            if ((i + 1) % 3 == 0) {
                Files.writeString(Paths.get(outputPath), inputData.get(i) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        }
    }
}
