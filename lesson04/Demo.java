package lesson04;

public class Demo {
    public static void main(String[] args) {
        //a_test withdraw
        //тест отстутствия имени в массиве --
        //тест ухода баланса в минус
        //тест нулевого массива
        String[] names = {"Name1", "Name2", "Name3", "Name4"};
        int[] balances = {100, 200, 0, 50};

        System.out.println(homeWork.withdraw(names, balances, "Name5", -500));
    }
}
