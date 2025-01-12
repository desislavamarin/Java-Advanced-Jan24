package Ex04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output4.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');
        int countVowels = 0;
        int countPunctuation = 0;
        int countSymbols = 0;

        try(BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
            BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader.readLine();

            //a, e, i, o, u are vowels, only lower case.
            //All others are other symbols.
            //Punctuation marks are (! , . ?).
            //Do not count whitespace.

            //Vowels: 41
            //Other symbols: 72
            //Punctuation: 6

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        countVowels++;
                    } else if (punctuation.contains(c)) {
                        countPunctuation++;
                    } else if (c != ' ') {
                        countSymbols++;
                    }
                }

                line = reader.readLine();
            }

            writer.write(String.format("Vowels: %d%n", countVowels));
            //writer.newLine();
            writer.write(String.format("Other symbols: %d%n", countSymbols));
            writer.write(String.format("Punctuation: %d", countPunctuation));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
