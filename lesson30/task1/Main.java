package lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank usbank = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        Bank eubank = new EUBank(1343, "Hungary", Currency.EUR, 50, 1200, 4, 45637291);
        Bank chinabank = new ChinaBank(789, "China", Currency.USD, 90, 1700, 5, 56789345);


        User firstUSBankUser = new User(1001, "Denis", 2200, 40, "GMD", 1500, usbank);
        User secondUSBankUser = new User(1002, "Victoria", 7800, 34, "World of Beauty", 750, usbank);

        User firstEUBankUser = new User(2001, "James", 7000, 60, "Mi6", 12000, eubank);
        User secondEUBankUser = new User(2002, "Chris", 2300, 18, "Naval", 9000, eubank);

        User firstChinaBankUser = new User(3001, "Pan", 2000, 18, "Trade Group", 1500, chinabank);
        User secondChinaBankUser = new User(3002, "Vong", 7000, 26, "Fishing Company", 2700, chinabank);

        User[] user = new User[]{firstChinaBankUser, secondChinaBankUser, firstEUBankUser, secondEUBankUser, firstUSBankUser, secondUSBankUser};
        BankSystem bankSystem = new UkrainianBankSystem();

        for (int i = 0; i < user.length; i++) {

            bankSystem.withdraw(user[i], 50);
            bankSystem.fund(user[i], 1000);
            if (i == (user.length - 1)) bankSystem.transferMoney(user[i], user[i - 3], 50);
            else bankSystem.transferMoney(user[i], user[i + 1], 50);
            bankSystem.paySalary(user[i]);
            System.out.println(user[i].toString() + " balance: " + user[i].getBalance());

        }


        /*Sys.out.println("before: " + firstEUBankUser.getBalance());
        Sys.out.println(firstEUBankUser.getBank());
        Sys.out.println("salary: " + firstEUBankUser.getSalary());
        Sys.out.println("limit: " + firstEUBankUser.getBank().getLimitOfFunding());

        bankSystem.paySalary(firstEUBankUser);
        Sys.out.println("after: " + firstEUBankUser.getBalance());*/

    }
    /*private static void userOperations(User user, int amount){
        BankSystem bankSystem = new UkrainianBankSystem();
        userDraw(user, amount, bankSystem);
        userFund(user, amount, bankSystem);
        userPaySalary(user, bankSystem);
    }

    private static void userDraw(User user, int amount, BankSystem bankSystem){
        bankSystem.withdraw(user, amount);
        Sys.out.println(user.getBalance());
    }
    private static void userFund(User user, int amount, BankSystem bankSystem){
        bankSystem.fund(user, amount);
        Sys.out.println(user.getBalance());
    }
    private static void userTransfer(User fromUser, User toUser, int amount){
        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.transferMoney(fromUser, toUser, amount);
        Sys.out.println("fromUser balance: " + fromUser.getBalance());
        Sys.out.println("toUser balance: " + toUser.getBalance());
    }
    private static void userPaySalary(User user){
        fund(user, user.getSalary());
        Sys.out.println(user.getBalance());
    }*/

}
