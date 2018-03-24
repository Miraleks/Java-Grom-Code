package lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator = new Validator("name");

        System.out.println(validator.getCheckCount());

    }
}