package lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user = new User(1001, "Ann", "lw21223");

        userRepository.save(user);
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение юзера ++
        //сохранение того же юзера ++
        //нет места в массиве ++
        //когда сохраняют null ++
        //проверить возвращаемое значение метода ++

        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann", "lw21223");
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(null);

        //a_test update
        user = new User(1001, "Ann", "secondSessionId");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //обычное обновление юзера ++
        //когда нет юзера на обновление
        //проверить обновляемое значение метода null

        user = new User(9999, "Ann", "secondSessionId");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

    }
}
