package Ex04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P06_WordCount {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPath2 = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

        Map<String, Integer> words = new HashMap<>();

        try(BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
            BufferedReader reader2 = Files.newBufferedReader(Path.of(inputPath2));
            BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader.readLine();

            while (line != null) {
                String[] input = line.split("\\s+");
                for (String word : input) {
                    words.put(word, 0);
                }

                line = reader.readLine();
            }

            line = reader2.readLine();

            while (line != null) {
                List<String> text = Arrays.stream(line.split("\\s+"))
                        .collect(Collectors.toList());

                words.forEach((k, v) -> {
                    int count = 0;
                    for (String word : text) {
                        if (word.equals(k)) {
                            count++;
                        }
                    }
                    words.put(k, words.get(k) + count);
                });

                line = reader2.readLine();
            }

            words.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(entry -> {
                        try {
                            writer.write(String.format("%s - %d\n", entry.getKey(), entry.getValue()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
