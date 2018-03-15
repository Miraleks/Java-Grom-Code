package lesson20.task1;


import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

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

    public User save(User user) throws Exception {
        if (user == null) {
            throw new BadRequestException("Can't save user");
        }

        int addedUser = -1;
        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        }catch (UserNotFoundException e){
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
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
            throw new InternalServerException("Not enought space to save user with id: " + user.getId());
    }

    public User findById(long id) throws UserNotFoundException{
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
            throw new UserNotFoundException("User with id: "+ id + " not found");

    }

    public User update(User user) throws Exception {

        findById(user.getId());

        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception {

        findById(id);

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == id) {
                    users[i] = null;
                    break;
                }
            }
        }
    }
}
