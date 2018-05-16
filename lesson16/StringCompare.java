package lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");

        System.out.println("Abc".equals("abc"));

        String s1 = "a_test";
        String s2 = "a_test";

        System.out.println(s1 == s2);

        // using intern

        String s3 = new String("pppp");
        String s4 = "pppp";

        System.out.println(s3 == s4);

        s3 = s3.intern();

        System.out.println(s3 == s4);

        //bytes of string

        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));

        System.out.println(new String(str.getBytes()));

    }
}
