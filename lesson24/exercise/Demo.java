package lesson24.exercise;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> systemDAO = new GeneralDAO<>();

        Sys sys1 = new Sys(11, "abc");
        systemDAO.save(sys1);

        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        systemDAO.save(sys1);

        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();

        Tool tool1 = new Tool("ads", "adsf");

        toolDAO.save(tool1);

        System.out.println(Arrays.deepToString(toolDAO.getAll()));






    }
}
