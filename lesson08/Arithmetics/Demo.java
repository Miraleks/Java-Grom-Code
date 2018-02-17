package lesson08.Arithmetics;

public class Demo {
    public static void main(String[] args) {
        int array[] = {12, 99, 42, 14, 32};

        Adder newAdder = new Adder();

        System.out.println(newAdder.check(array));
        System.out.println(newAdder.add(17, 36));
    }
}
