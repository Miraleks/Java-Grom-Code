package lesson15HW.part2;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        if (rooms == null || rooms.length == 0)
            return null;
        double maxPrice = price + 100;
        int minPrice = price - 100;
        if ((price - 100) < 0) {
            minPrice = 0;
        }

        int counter = -1;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() <= maxPrice && rooms[i].getPrice() >= minPrice && rooms[i].getPersons() == persons && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
                counter++;

            }
        }
        if (counter < 0) {
            return null;
        } else {
            Room[] result = new Room[counter + 1];
            int counter2 = 0;
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].getPrice() <= maxPrice && rooms[i].getPrice() >= minPrice && rooms[i].getPersons() == persons && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
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
