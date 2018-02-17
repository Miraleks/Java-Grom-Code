package lesson11HW;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    /*
    * Room[] requestRooms(int price, int persons, String city, String hotel)
    Который используя все реализации интерфейса API, находит комнаты по заданным параметрам

    Room[] check(API api1, API api2)
    Который находит общие комнаты у двух API (в результирующий массив добавлять комнаты с api1).
    Комнаты будем считать равными, если у них одинаковые все поля кроме id и dateAvailableFrom. Гарантируется что id комнаты уникальный во всей системе
    */

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        int counterRooms = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                counterRooms += api.findRooms(price, persons, city, hotel).length;
            }
        }
        if (counterRooms == 0) {
            return null;
        }

        Room[] result = new Room[counterRooms];

        int counter = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    result[counter] = room;
                    counter++;
                }

            }
        }
        return result;

    }

    public Room[] check(API api1, API api2) {

        Room[] allRoomApi1 = api1.getAll();
        Room[] allRoomApi2 = api2.getAll();

        int duplicate = 0;

        for (Room room : allRoomApi1) {
            for (Room room2 : allRoomApi2) {
                if (room.getPrice() == room2.getPrice() && room.getPersons() == room2.getPersons() && room.getHotelName() == room2.getHotelName() && room.getCityName() == room2.getCityName()) {
                    duplicate++;
                }
            }
        }

        Room[] result = new Room[duplicate];
        int counter = 0;

        for (Room room : allRoomApi1) {
            for (Room room2 : allRoomApi2) {
                if (room.getPrice() == room2.getPrice() && room.getPersons() == room2.getPersons() && room.getHotelName() == room2.getHotelName() && room.getCityName() == room2.getCityName()) {
                    result[counter] = room;
                }
            }
        }
        return result;
    }

}