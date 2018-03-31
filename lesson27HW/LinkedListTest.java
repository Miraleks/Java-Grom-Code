package lesson27HW;

import java.util.LinkedList;

public class LinkedListTest {

    Order order1 = new Order(21341234,254,"USD", "Pen", "FirstShop");
    Order order2 = new Order(21341235,250,"EUR", "Pencil", "SecondShop");
    Order order3 = new Order(21341236,25,"USD", "Paper", "ThirdShop");
    Order order4 = new Order(21341237,354,"UAH", "Marker", "ForthShop");
    Order order5 = new Order(21341238,264,"DRH", "stapler", "FifthShop");


    public LinkedList<Order> useList(){

        LinkedList<Order> list = new LinkedList<>();

        list.add(order1);
        list.add(order2);
        list.add(order3);

        list.add(2, order4);

        list.add(order5);

        list.remove(3);

        list.add(3, new Order(200000008,20004,"RUB", "Notebook", "HeadOffice"));

        list.remove(order3);

        System.out.println(list.contains(order5));
        System.out.println(list.contains(order3));

        System.out.println(list.subList(1, 2));

        LinkedList<Order> list2 = new LinkedList<>();

        list2.add(order5);
        list2.add(order4);
        list2.add(1, order1);

        list.addAll(list2);

        list.set(2, order3);

        Object[] object = list.toArray();

        list.clear();

        list.add(order1);
        list.add(order5);
        list.add(order3);
        list.add(order4);
        list.add(order2);




        return list;
    }
}
