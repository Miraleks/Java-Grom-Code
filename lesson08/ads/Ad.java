package lesson08.ads;

import java.util.Date;

public class Ad extends BaseEntity {
    int price;
    Date dateCreated;

    public Ad(long id, int price) {
        super(id);
        this.id = id;
        this.dateCreated = new Date();
    }

    void publishAd() {
        //some logic
    }
}

