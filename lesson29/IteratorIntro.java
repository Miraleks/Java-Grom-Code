package lesson29;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class IteratorIntro {
    public static void main(String[] args) {
        Set<File> files = new LinkedHashSet<>();
        File file1 = new File("pict.txt", 100);
        File file2 = new File("home.txt", 178);
        File file3 = new File("class.txt", 50);
        File file4 = new File("class.txt", 150);

        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);

        for (File file : files) {
            System.out.println(file.getFileName());
        }

    }
}
