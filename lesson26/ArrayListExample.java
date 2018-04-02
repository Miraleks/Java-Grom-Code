package lesson26;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {

        int[] test = new int[5];
        test[0] = 10;
        //..

        int[] test1 = {1, 2, 3};


        //ArrayList

        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(12);
        list.add(7);

        System.out.println(list.toString());

        list.remove(1);
        System.out.println(list.toString());

        list.add(11);
        list.add(11);
        System.out.println(list.toString());

        list.add(2, 33);
        System.out.println(list.toString());

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);

        list.addAll(list1);
        System.out.println(list.toString());

        list.set(3, 5555);
        System.out.println(list.toString());

        list.clear();
        System.out.println(list.toString());

        ArrayList<String> listString = new ArrayList<>();


        listString.add("one");
        listString.add("two");
        listString.add("three");
        listString.add("four");

        System.out.println(listString.toString());
        System.out.println(listString.size());

        listString.remove(2);

        System.out.println(listString.toString());
        System.out.println(listString.size());




    }
}
