package lesson25;

public class Order extends IdEntity {
    private long id;

    @Override
    public long getId() {
        return id;
    }

    public Order(long id) {
        this.id = id;
    }
}
