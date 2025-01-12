package L04_StreamsFilesAndDirectories;

public class Demo {
    public static void main(String[] args) {

        /*//Opening a File Stream
        String path = "D:\\softuni\\Java Advanced\\input.txt"; //поставяме абсолютния път на файла
        FileInputStream fileStream =
                null; //alt + enter -> добавяне към сигнатурата на метода
        try {
            fileStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.print(oneByte);
            oneByte = fileStream.read();
        }*/

        /*//closing a file stream
        InputStream in = null;
        try {
            in = new FileInputStream(path);
        } catch (IOException e) {
            // TODO: handle exception
        } finally {
            if (in != null) {
                in.close();
                //съкратено изписване е с try with resources
            }
        }*/

        /*try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.print(oneByte);
                oneByte = in.read();
            }
        } catch (IOException e) {
            // TODO: handle exception
        }*/


        //Serialization -> save object to a file
        /*List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos =
                new ObjectOutputStream(fos);
        oos.writeObject(names);*/

        //Deserialization
        /*FileInputStream fis =
                new FileInputStream(path);
        ObjectInputStream oos =
                new ObjectInputStream(fis);
        List<String> names =
                (List<String>) oos.readObject();*/


    }
}
