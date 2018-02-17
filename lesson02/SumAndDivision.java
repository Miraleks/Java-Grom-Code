package lesson02;

public class SumAndDivision {
    public static void main(String[] args) {
        long b = 0;
        int e = 1234;
        for (int a = 0; a <= 1000; a++) {
            b += a;
        }
        long div = b / e;
        long mod = b % e;
        System.out.println(div < mod);
    }
}
