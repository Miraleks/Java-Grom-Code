package lesson03;

public class FindOdd {
    public static void main(String[] args) {
        int sumOdd = 0;
        for (int a = 1; a <= 1000; a++) {
            if (a % 2 != 0) {
                sumOdd += a;
                System.out.println("Found");
                //Sys.out.println(sumOdd);
            }
        }
        if (sumOdd * 5 > 5000) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }

    }
}
