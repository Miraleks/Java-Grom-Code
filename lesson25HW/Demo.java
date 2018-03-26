package lesson25HW;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {


        GeneralDAO<Integer> intDAO = new GeneralDAO();
        GeneralDAO<String> stringDAO = new GeneralDAO();
        GeneralDAO<Double> dobDAO = new GeneralDAO();

        int a = 120;
        String name = "Alex";
        double value = 12.25;

        intDAO.save(a);

        stringDAO.save(name);

        dobDAO.save(value);

        System.out.println(Arrays.deepToString(intDAO.getAll()));
        System.out.println(Arrays.deepToString(stringDAO.getAll()));
        System.out.println(Arrays.deepToString(dobDAO.getAll()));



    }
}
