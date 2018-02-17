package lesson07;

import lesson06.Car;
import lesson06.DbConnector;
import lesson06.User;

public class Demo {
    public static void main(String[] args) {
        //to options to create object
        //class name (type) object name = new class name();
        //class name (type) object name = new class name(attributes);

        User user = new User();
        User user1 = new User();
        User user2 = new User();

        User user3 = new User("Jack");

        Car car = new Car(10000, 2015, "Anton");

        DbConnector dbConnector = new DbConnector();
    }

}
