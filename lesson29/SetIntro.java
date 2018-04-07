package lesson29;

import java.util.HashSet;
import java.util.Set;

public class SetIntro {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("testStr");

        set.add("111");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("222");

        System.out.println(set);

        Set<File> files = new HashSet<>();
        File file1 = new File("pict.txt", 100 );
        File file2 = new File("home.txt", 178 );
        File file3 = new File("class.txt", 50 );
        File file4 = new File("class.txt", 150 );

        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);


        System.out.println(files);






    }
}
