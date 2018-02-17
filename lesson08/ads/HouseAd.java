package lesson08.ads;

public class HouseAd extends Ad {
    String ownerName;
    String address;
    double square;
    int floor;

    public HouseAd(long id, int price, String ownerName, String address, double square, int floor) {
        super(id, price);
        this.ownerName = ownerName;
        this.address = address;
        this.square = square;
        this.floor = floor;
    }

    boolean checkOwnerOfAd() {
        Owners owners = new Owners();

        for (String owner : owners.owners) {
            if (ownerName == owner)
                return true;
        }
        return false;
    }
}
