package Ex04_StreamsFilesAndDirectories;

public class Demo {
    public static void main(String[] args) {

        /*

        FileInputStream, FileOutputStream - Read and Write byte by byte

        FileReader, FileWriter - Read and Write character by character

        Scanner() - uses InputStream

        PrintWriter -  uses Writer

        BufferedReader, BufferedWriter - uses Reader and Writer

        */

        //reading file
        /*String path = "D:\\softuni\\Java Advanced\\Files-and-Streams\\input.txt"; //поставяме абсолютния път на файла

        try (FileInputStream fileStream = new FileInputStream(path);) {

            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileStream.read();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
