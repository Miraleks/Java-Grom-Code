package lesson09;


public class UserRepository {
    User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if (users == null || users.length == 0)
            return null;
        String[] userNames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                userNames[i] = users[i].getName();
        }
        return userNames;
    }

    public long[] getUserIds() {
        if (users == null || users.length == 0)
            return null;
        int counter = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                counter++;
            }
        }
        long[] userId = new long[counter];
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                userId[j] = users[i].getId();
                j = j + i;
            } else {
                j = j - 1;
            }
        }
        return userId;
    }

    public String getUserNameById(long id) {
        int clientIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getId() == id) {

                    clientIndex = i;
                }
        }
        if (clientIndex >= 0)
            return users[clientIndex].getName();
        else
            return null;
    }
//    getUserByName(String name) - нахождение юзера по имени

    public User getUserByName(String name) {
        int clientIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getName() == name) {

                    clientIndex = i;
                }
        }
        if (clientIndex >= 0)
            return users[clientIndex];
        else
            return null;

    }

//    getUserById(long id) - нахождение юзера по id

    public User getUserById(long id) {
        int clientIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getId() == id) {

                    clientIndex = i;
                }
        }
        if (clientIndex >= 0)
            return users[clientIndex];
        else
            return null;

    }

    public User getUserBySessionId(String sessionId) {
        int clientIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getSessionId() == sessionId) {

                    clientIndex = i;
                }
        }
        if (clientIndex >= 0)
            return users[clientIndex];
        else
            return null;

    }

    /*
    User save(User user) - будет добавлять юзера и возвращать его
    Eсли юзер уже есть в массиве, результат - null.
    Если размер массива не позволяет добавить больше элементов (все ячейки заняты) результат метода тоже null
    Метод должен быть доступен всем
    Используйте метод с предыдущих задач для нахождение юзера по id. Только переменуйте его в findById(long id).
    Метод должен быть доступен, только внутри класса UserRepository
     */
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
    /*
   User update(User user) - будет обновлять текущего юзера в массиве (перезаписывать) и возвращать его. Если юзера нет, результат метода null
void delete(long id) - удаляет юзера с массива

Методы должны быть доступны всем

Используйте метод findById(long id) с предыдущих задач для нахождение юзера по id. Метод должен быть доступен, только внутри класса UserRepository
     */

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
}
