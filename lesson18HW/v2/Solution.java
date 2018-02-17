package lesson18HW.v2;

import static java.lang.Character.isDigit;

public class Solution {

    static public int[] findNumbers(String text) {
        if (text.isEmpty()) return null;

        int counterNumbers = 0;
        String[] words = text.split(" ");
        for (String word : words) {

            if (wordChecking(word)) {
                counterNumbers++;
            } else {
                System.out.println("not a number");
            }
        }
        int[] results = new int[counterNumbers];
        int resIndex = 0;
        for (String word : words) {
            if (wordChecking(word)) {
                results[resIndex] = Integer.parseInt(word);
                resIndex++;
            }
        }
        return results;

    }

    static public boolean wordChecking(String input) {
        char[] chars = input.toCharArray();
        boolean wordChecking = false;
        for (Character character : chars) {
            if (isDigit(character))
                wordChecking = true;
            else {
                wordChecking = false;
                break;
            }
        }
        return wordChecking;
    }
}
