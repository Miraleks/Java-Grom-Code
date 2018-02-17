package lesson11HW;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        if (rooms == null || rooms.length == 0)
            return null;
        double maxPersons = persons + 1;
        int minPersons = persons - 1;
        if ((persons - 1) < 1) {
            minPersons = 1;
        }

        int counter = -1;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPersons() <= maxPersons && rooms[i].getPersons() >= minPersons && rooms[i].getPrice() == price && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
                counter++;

            }
        }
        if (counter < 0) {
            return null;
        } else {
            Room[] result = new Room[counter + 1];
            int counter2 = 0;
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].getPersons() <= maxPersons && rooms[i].getPersons() >= minPersons && rooms[i].getPrice() == price && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
                    result[counter2] = rooms[i];
                    counter2++;
                }
            }
            return result;
        }

    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
