package lesson24.firstexample;

public class Main {

    private static void demo() {

        User user = new User(11);
        Solution solution = new Solution("test1");

        Demo<User> demo = new Demo<>();
        Demo<Solution> demo1 = new Demo<>();

        demo.print(user);

        demo1.print(solution);
    }

    public static void main(String[] args) {
        demo();
    }




}
