package lesson16HW;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLetterOrDigit;

public class Solution {

    static int countWords(String input) {

        if (!input.isEmpty()) {
            int res = 0;
            String[] words = input.split(" ");
            for (String word : words) {

                if (wordChecking(word) == true) res++;
            }
            return res;
        }
        return 0;
    }

    static String maxWord(String input) {
        if (!input.isEmpty()) {
            String[] words = input.split(" ");
            int counter = 0;
            long maxCharsInWord = 0;
            for (int i = 0; i < words.length; i++) {

                if (wordChecking(words[i])) {
                    byte[] charsInWord = words[i].getBytes();
                    if (charsInWord.length > maxCharsInWord) {
                        maxCharsInWord = charsInWord.length;
                        counter = i;
                    }
                }
            }
            if (maxCharsInWord == 0) return null;
            return words[counter];
        }
        return null;
    }

    static String minWord(String input) {
        if (!input.isEmpty()) {
            String[] words = input.split(" ");
            int counter = 0;
            int minCharsInWord = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {

                if (wordChecking(words[i])) {
                    byte[] charsInWord = words[i].getBytes();
                    if (charsInWord.length < minCharsInWord) {
                        minCharsInWord = charsInWord.length;
                        counter = i;
                    }

                }
            }
            if (minCharsInWord == Integer.MAX_VALUE) return null;
            return words[counter];
        }
        return null;
    }

    static String mostCountedWord(String input) {
        if (!input.isEmpty()) {
            String[] words = input.split(" ");
            int mostDuplicateWordNumber = -1;
            int mostDuplicate = 0;
            for (int i = 0; i < words.length; i++) {
                int counter = 0;
                if (wordChecking(words[i])) {
                    for (int j = 0; j < words.length; j++) {
                        if (wordChecking(words[j])) {
                            if (words[i].equals(words[j])) {
                                counter++;
                            }
                        }
                    }
                }
                if (counter > mostDuplicate) {
                    mostDuplicate = counter;
                    mostDuplicateWordNumber = i;
                }
            }
            if (mostDuplicateWordNumber < 0) return null;
//            System.out.println("mostDuplicate for " + input + ": " + mostDuplicate);
            return words[mostDuplicateWordNumber];
        }
        return null;
    }

    static boolean validate(String address) {
        if (address == null) return false;
        if (address.isEmpty()) return false;

        String addr = address.toLowerCase();

        String[] protocol = new String[]{"http://", "https://"};

        String[] permDomainZone = new String[]{".com", ".org", ".net"};

        boolean flagProt = false;
        boolean flagZone = false;

        for (String prot : protocol) {
            if (addr.startsWith(prot)) {
                flagProt = true;
                addr = addr.replace(prot, "");
                break;
//                System.out.println("Cut done: " + addr);
            }
        }
        for (String zone : permDomainZone) {
            if (addr.endsWith(zone)) {
                flagZone = true;
                addr = addr.replace(zone, "");
                break;
//                System.out.println("Cut done: " + addr);
            }
        }
        char[] addressToChar = addr.replace("www.", "").toCharArray();
        for (char chars : addressToChar) {
            if (!isLetterOrDigit(chars)) return false;

        }
        return (flagZone && flagProt);
    }

    static public boolean wordChecking(String input) {
        char[] chars = input.toCharArray();
        boolean wordChecking = false;
        for (Character character : chars) {
            if (isLetter(character))
                wordChecking = true;
            else {
                wordChecking = false;
                break;
            }
        }
        return wordChecking;
    }
}
