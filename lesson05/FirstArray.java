package lesson05;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {
        int a;
        a = 10;

        int[] firstArray = new int[4]; //декларируем
        System.out.println(Arrays.toString(firstArray));
        firstArray[0] = 11;
        firstArray[1] = 200;
        firstArray[2] = -10;

        for (int i = 0; i < firstArray.length; i++) {
            System.out.println(firstArray[i]);
        }

        System.out.println(Arrays.toString(firstArray));

        int b = 10;
        int[] secondArray = {1, 10, 15, 20, -50};
        System.out.println(Arrays.toString(secondArray));

        //for-each
        for (int element : secondArray)
            System.out.println(element);


    }
}