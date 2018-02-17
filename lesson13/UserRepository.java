package lesson13;


public class UserRepository {
    private User[] users = new User[10];

    public User save(User user) {
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
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getId() == id) {
                        users[i] = null;
                    }
                }
            }
        }
    }

    public User[] getUsers() {
        return users;
    }

    public User getFindById(long id) {
        return findById(id);
    }
}
