package lesson18HW.v1;

public class Solution {

    static public int[] findNumbers(String text) {
        if (text.isEmpty()) return null;

        int counterNumbers = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            try {
                Integer.parseInt(word);
                counterNumbers++;
            } catch (Exception e) {
                System.out.println("not a number");
            }

        }
        int[] results = new int[counterNumbers];
        int resIndex = 0;
        for (String word : words) {
            try {
                results[resIndex] = Integer.parseInt(word);
                resIndex++;
            } catch (Exception e) {


            }
        }
        return results;

    }
}
