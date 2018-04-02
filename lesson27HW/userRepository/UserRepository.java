package lesson27HW.userRepository;


import java.util.ArrayList;

public class UserRepository {

    ArrayList<User> list = new ArrayList<>();

    public UserRepository(ArrayList<User> list) {
        this.list = list;
    }

    public ArrayList<User> getUsers() {
        return list;
    }

    public ArrayList<String> getUserNames() throws Exception{
        if (list.isEmpty())
            throw new NullPointerException("List is empty");

        ArrayList<String> userNames = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() != null)
                userNames.add(list.get(i).getName());
        }
        return userNames;
    }

    public ArrayList<Long> getUserIds() throws Exception {

        if (list.isEmpty())
            throw new NullPointerException("List is empty");

        ArrayList<Long> userId = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() != 0)
                userId.add(list.get(i).getId());
        }
        return userId;

    }

    public String getUserNameById(long id) throws Exception {

        if(list.contains(id)){
            return list.get(list.indexOf(id)).getName();
        }

        throw new Exception("Object with id: " + id + " not found");
    }
//    getUserByName(String name) - нахождение юзера по имени

    public User getUserByName(String name) throws Exception {

        if(list.contains(name)){
            return list.get(list.indexOf(name));
        }

        throw new Exception("Object with name: " + name + " not found");

    }

//    getUserById(long id) - нахождение юзера по id

    public User getUserById(long id) throws Exception {

        if(list.contains(id)){
            return list.get(list.indexOf(id));
        }
        throw new Exception("Object with id: " + id + " not found");

    }

    public User getUserBySessionId(String sessionId) throws Exception {

        if(list.contains(sessionId)){
            return list.get(list.indexOf(sessionId));
        }
        throw new Exception("Object with sessionId: " + sessionId + " not found");
    }

    /*
    User save(User user) - будет добавлять юзера и возвращать его
    Eсли юзер уже есть в массиве, результат - null.
    Если размер массива не позволяет добавить больше элементов (все ячейки заняты) результат метода тоже null
    Метод должен быть доступен всем
    Используйте метод с предыдущих задач для нахождение юзера по id. Только переменуйте его в findById(long id).
    Метод должен быть доступен, только внутри класса UserRepository
     */
    public User save(User user) throws Exception {
        if (user == null && list.contains(user)) {
            throw new Exception("Object: " + user.toString() + " not found");
        }

        list.add(user);
        return user;

    }

    public User findById(long id) throws Exception {

        if(list.contains(id)){
            return list.get(list.indexOf(id));
        }
        throw new Exception("Object with id: " + id + " not found");
    }

    /*
   User update(User user) - будет обновлять текущего юзера в массиве (перезаписывать) и возвращать его. Если юзера нет, результат метода null
void delete(long id) - удаляет юзера с массива

Методы должны быть доступны всем

Используйте метод findById(long id) с предыдущих задач для нахождение юзера по id. Метод должен быть доступен, только внутри класса UserRepository
     */

    public User update(User user) throws Exception {
        if (user != null) {

            if(list.contains(user)){
                list.set(list.indexOf(user), user);
                return list.get(list.indexOf(user));
            }

        }
        throw new Exception("Object: " + user.toString() + " not found");
    }

    public void delete(long id) throws Exception {

        if(list.contains(id)){
            list.remove(list.indexOf(id));

        }
        throw new Exception("Object with id: " + id + " not found");



    }
}
