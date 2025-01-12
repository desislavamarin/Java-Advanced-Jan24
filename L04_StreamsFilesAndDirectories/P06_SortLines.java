package L04_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\softuni\\Java Advanced\\resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\resources\\06.SortLinesOutput.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));
        Collections.sort(inputData);
        Files.write(Paths.get(outputPath), inputData);

    }
}
