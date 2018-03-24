package lesson15HW.part1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(1001, "Ann1", "id1001");
        User user2 = new User(1002, "Ann2", "id1002");
        User user3 = new User(1003, "Ann3", "id1003");
        User user4 = new User(1004, "Ann4", "id1004");

        User user5 = new User(1002, "Ann2", "id1002");

        User user6 = new User(1006, "Ann6", "id1006");

//        User[] users = new User[]{user1, user2, user3, user4, null};

        UserRepository userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.users));

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);


        System.out.println(Arrays.deepToString(userRepository.users));

        System.out.println("User updated: " + userRepository.update(user3));
        System.out.println("User saved: " + userRepository.save(user6));

        System.out.println(Arrays.deepToString(userRepository.users));

        userRepository.delete(1003);
        userRepository.delete(0);

        //Sys.out.println("User delete: user6");

        System.out.println(Arrays.deepToString(userRepository.users));
    }
}
