package lesson18HW;

import lesson18HW.v1.Solution;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String test = "00 sd23kjh 124313 12 231 3123 kfjlsdfkj 21  ";
        String test1 = new String();
        String test2 = test1;

        System.out.println(Arrays.toString(Solution.findNumbers(test)));
        System.out.println(Arrays.toString(Solution.findNumbers(test1)));
        System.out.println(Arrays.toString(Solution.findNumbers(test2)));

        System.out.println(Arrays.toString(lesson18HW.v2.Solution.findNumbers(test)));
        System.out.println(Arrays.toString(lesson18HW.v2.Solution.findNumbers(test1)));
        System.out.println(Arrays.toString(lesson18HW.v2.Solution.findNumbers(test2)));
    }
}
