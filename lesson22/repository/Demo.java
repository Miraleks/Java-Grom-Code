package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(1001, "Daniil", "324234234dfsdf");
        UserRepository.save(user1);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2 = new User(1002, "Andrey", "dasfsdfsdf34df");
        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3 = new User(1001, "Test", "d24234234dfsdf");
        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

    }
}
