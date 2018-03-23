package lesson22.repository;

public class UserRepository {

    private static User[] users = new User[10];

    public static User save(User user) {
        if (user == null) {
            return null;
        }
        int addedUser = -1;
        if (findById(user.getId()) != null) {
            return null;
        } else {
            for (int i = 0; i < users.length; i++) {

                if (users[i] == null) {
                    users[i] = user;
                    addedUser = i;
                    break;
                }
            }
        }
        if (addedUser >= 0)
            return users[addedUser];
        else
            return null;
    }
    public static User update(User user) {
        if (user != null) {
            for (int i = 0; i < users.length; i++) {
                if (findById(user.getId()) != null) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }
    public static void delete(long id) {
        User user = findById(id);
        if (user == null) return;

        int index = 0;
        for (User us : users) {
            if (us.getId() == user.getId()) {
                users[index] = null;
                break;
            }
            index++;
        }
    }
    private static User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public static User[] getUsers() {
        return users;
    }
}
