package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {


        String test = "someStringExample";

        System.out.println(test.isEmpty());

        System.out.println("".isEmpty());

        System.out.println(test.length());

        System.out.println(test.charAt(2));

        String res = test.replace("me", "T");
        System.out.println(res);

        System.out.println(test.replaceAll("me", "T"));


        System.out.println(test);
        System.out.println(test.contains("mes"));

        System.out.println(test);
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));

        System.out.println(" test a".trim());

        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5, 10).trim());


        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());

        String string = "Madam, I am Adam";

// Starts with
        System.out.println(string.startsWith("Mad"));  // true

// Ends with
        System.out.println(string.endsWith("dam"));             // true

// Anywhere
        System.out.println(string.lastIndexOf("I am"));        // true

// To ignore case, regular expressions must be used


    }
}
