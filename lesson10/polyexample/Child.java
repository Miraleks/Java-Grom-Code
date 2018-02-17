package lesson10.polyexample;

public class Child extends Human {
    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class is called...");
        super.run();
    }
}
