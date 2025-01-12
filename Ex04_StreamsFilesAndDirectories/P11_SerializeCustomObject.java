package Ex04_StreamsFilesAndDirectories;

import java.io.*;

public class P11_SerializeCustomObject {
    public static void main(String[] args) {

        P11_Course course = new P11_Course("Java Advanced", 100);

        String path = "D:\\softuni\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
                ) {

            //serializing
            objectOutputStream.writeObject(course);

            //deserializing
            Object deserializedCourse = (P11_Course) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
