package lesson30.task1;

public class Demo {

    public static void main(String[] args) throws Exception {

        Bank usbank = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        Bank eubank = new EUBank(1343, "Hungary", Currency.EUR, 50, 1200, 4, 45637291);
        Bank chinabank = new ChinaBank(789, "China", Currency.USD, 90, 1700, 5, 56789345);


//        User firstUSBankUser = new User(1001, "Denis", 2200, 40, "GMD", 1500, usbank);
//        User secondUSBankUser = new User(1002, "Victoria", 7800, 34, "World of Beauty", 750, usbank);

        User firstEUBankUser = new User(2001, "James", 7000, 60, "Mi6", 12000, eubank);
        User secondEUBankUser = new User(2002, "Chris", 2300, 18, "Naval", 9000, eubank);

//        User firstChinaBankUser = new User(3001, "Pan", 2000, 18, "Trade Group", 1500, chinabank);
//        User secondChinaBankUser = new User(3002, "Vong", 7000, 26, "Fishing Company", 2700, chinabank);

//        User[] users = new User[]{firstChinaBankUser, secondChinaBankUser, firstEUBankUser, secondEUBankUser, firstUSBankUser, secondUSBankUser};
        UkrainianBankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(firstEUBankUser, 150);

        Thread.sleep(2000);

        bankSystem.withdraw(firstEUBankUser, 10);


        System.out.println(bankSystem.getTransactions());
    }

}
