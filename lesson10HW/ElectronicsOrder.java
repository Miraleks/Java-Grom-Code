package lesson10HW;

import java.util.Date;

public class ElectronicsOrder extends Order {

    Order orderElectronics;


    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {

        String[] city = {"Киев", "Одесса", "Днепр", "Харьков"};
        if (getCustomerOwned() != null && getCustomerOwned().getGender() == "Женский" && getBasePrice() >= 100) {

            if (validateCity(city, getShipFromCity()) && validateCity(city, getShipToCity())) {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    public void calculatePrice() {
        if (getShipToCity() == null) {
            return;
        }
        double discount = 0;
        double shippingPrice = 0;
        if (getBasePrice() > 0) {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса") {
                shippingPrice = getBasePrice() * 0.1;
            } else {
                shippingPrice = getBasePrice() * 0.15;
            }
            if (getBasePrice() + shippingPrice > 1000) {
                discount = (getBasePrice() + shippingPrice) * 0.05;
            }

            setTotalPrice(getBasePrice() + shippingPrice - discount);

        }
    }
}
