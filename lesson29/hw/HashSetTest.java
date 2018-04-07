package lesson29.hw;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashSetTest {

    Order order1 = new Order(1001, 100, "USD", "door", "rozetka.ua");
    Order order2 = new Order(1002, 200, "EUR", "window", "epicentr");
    Order order3 = new Order(1003, 60, "USD", "wallpaper", "epicentr");
    Order order4 = new Order(1004, 1470, "UAH", "knife", "nova liniya");
    Order order5 = new Order(1005, 120, "USD", "book", "bookstore");


    public Set<Order> useHashSet(){

        Set<Order> list = new HashSet<>();

        LinkedList<Order> linkedList= new LinkedList<>();

        linkedList.add(order1);
        linkedList.add(order3);
        linkedList.add(order2);

        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);

        System.out.println(list);

//        add(E e)
//        remove(E e)
//        retailAll(Collection<E> c) - на уроке не проходили, попробуйте разобраться что делает этот метод самостоятельно - удаляет все, кроме существующих в передаваемой коллекции
//        Object[] toArray()
//        size()

        list.remove(order3);

        System.out.println("Delete order3: " + list);

        list.retainAll(linkedList);

        System.out.println("retain collection LinkedList(order3): " + list);

        list.add(order3);
        list.add(order4);
        list.add(order5);

        Object[] objects =  list.toArray();

        for(Object object : objects){
            System.out.println(object);
        }

        System.out.println("size: " + list.size());

        list.add(new Order(1008,204,"RUB", "Notebook", "HeadOffice"));


        return list;
    }

}
