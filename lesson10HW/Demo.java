package lesson10HW;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("TV Panasonic", new Date(), "Киев", "Одесса", 15000, new Customer("Алексей", "Одесса", "Мужской"), 12);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Microwave Oven", new Date(), "Харьков", "Киев", 800, new Customer("Анна", "Харьков", "Женский"), 12);

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();

        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Диван", new Date(), "Киев", "Харьков", 5500, new Customer("Алексей", "Харьков", "Мужской"), "10645");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Шкаф", new Date(), "Днепр", "Львов", 2500, new Customer("Анна", "Львов", "Женский"), "10646");

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();

        furnitureOrder2.validateOrder();
        furnitureOrder2.calculatePrice();

    }
}
