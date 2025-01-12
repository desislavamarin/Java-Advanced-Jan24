package L04_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08_NestedFolders {
    public static void main(String[] args) throws IOException {

        String path = "D:\\softuni\\Java Advanced\\resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");

        /*Map<Path, Path> data = Files.walk(f.toPath(), FileVisitOption.FOLLOW_LINKS)
                .collect(Collectors.toMap(Function.identity(), e -> e));*/

    }
}
