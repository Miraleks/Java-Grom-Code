package lesson08.phones;

public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0, "China", true);
        iPhone.deleteIPhoneFromDb();
        iPhone.orderPhone();
    }
}
