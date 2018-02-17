package lesson05;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};


        System.out.println(withdraw(names, balances, "Ann", 150));

        System.out.println(Arrays.toString(balances));

    }

    static String[] findClientsByBalance(String[] clients, int[] balances, int n) {


        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;

    }

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {

        //String[] results = new String[clients.length];

        //находим кол-во результатов
        //создаем массив с длинной результатов
        //записываем результы

        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;

    }

    static void depositMoney(String[] clients, int[] balances, String client, int money) {
        //1. найти клиента в базе(в нашем случае в массивах)
        //2. считаем сумму пополнения с учетом комиссии
        //3. обновляем баланс (пополняем)

        //int clientIndex = findClientIndexByName(clients, client);

        //int moneyToDeposit = calculateDepositAmountAfterCommission(money);

        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
    }

    static long withdraw(String[] clients, int[] balances, String client, int amount) {

        long balanceAfterAmount = balances[findClientIndexByName(clients, client)] - amount;
        if (balanceAfterAmount < 0) {
            return -1;
        }
        balances[findClientIndexByName(clients, client)] -= amount;
        return balanceAfterAmount;
    }

    static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;

        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }

    static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }


}
