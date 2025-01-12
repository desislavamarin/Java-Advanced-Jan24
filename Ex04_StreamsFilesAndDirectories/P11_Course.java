package Ex04_StreamsFilesAndDirectories;

import java.io.Serializable;

public class P11_Course implements Serializable {
    private String name;
    private int students;

    public P11_Course(String name, int students) {
        this.name = name;
        this.students = students;
    }
}
