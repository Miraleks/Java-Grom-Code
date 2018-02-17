package lesson15.cast;

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) test();

        System.out.println(provider);
    }

    static Provider test() {
        return new InternetProvider();
    }

    static Provider testFood() {
        return new InternetProvider();
    }

}
