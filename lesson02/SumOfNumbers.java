package lesson02;

public class SumOfNumbers {
    public static void main(String[] args) {
        long b = 0;
        for (long a = 0; a <= 1000000; a++) {
            b += a;
        }
        System.out.println(b);
    }
}
