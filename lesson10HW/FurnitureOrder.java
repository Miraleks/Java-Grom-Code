package lesson10HW;

import java.util.Date;

public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {

        String[] city = {"Киев", "Львов"};

        if (getCustomerOwned() != null && getCustomerOwned().getName() != "Тест" && getBasePrice() >= 500) {

            if (validateCity(city, getShipFromCity())) {
                setDateConfirmed(new Date());
            }
        }
    }


    @Override
    public void calculatePrice() {

        double shippingPrice;
        if (getBasePrice() > 499) {
            if (getBasePrice() < 5000) {

                shippingPrice = getBasePrice() * 0.05;
            } else {
                shippingPrice = getBasePrice() * 0.02;
            }

            setTotalPrice(getBasePrice() + shippingPrice);

        }
    }


}


