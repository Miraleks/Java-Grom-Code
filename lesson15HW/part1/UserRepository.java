package lesson15HW.part1;

public class UserRepository {
    User[] users = new User[10];

    public User save(User user) {
        if (user == null) {
            return null;
        }
        if (users == null) {
            return null;
        }

        int addedUser = -1;
        for (User findUser : users) {
            if (findUser != null) {
                if (findUser.equals(user)) return null; // если юзер есть, то null
            }
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                addedUser = i;
                break;
            }
        }
        if (addedUser >= 0)
            return users[addedUser];
        else
            return null;
    }

    public User update(User user) {
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

    public void delete(long id) {
        if (findById(id) != null) {
            if (users == null) {
                return;
            }
            int pointerId = 0;
            for (User findUser : users) {
                if (findUser != null) {
                    if (findUser.getId() == id) {
                        users[pointerId] = null;
                    }
                }
                pointerId++;
            }
        }
    }

    private User findById(long id) {
        int userIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getId() == id) {

                    userIndex = i;
                }
        }
        if (userIndex >= 0)
            return users[userIndex];
        else
            return null;
    }

}
