package lesson04;

import java.util.Arrays;

public class homeWork {

    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(names, balances, "Ann", 150));

        System.out.println(Arrays.toString(balances));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount) {

        if (balances[findClientIndexByName(clients, client)] <= 0) {
            return -1;
        }
        int balanceAfterAmount = balances[findClientIndexByName(clients, client)] - amount;
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
}

