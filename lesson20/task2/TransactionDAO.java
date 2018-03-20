package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {

        if (transaction == null) {
            throw new NullPointerException("null data is detected");
        }

        validate(transaction);
        checkTransactionCity(transaction);

        for (Transaction tr : transactions) {
            if (transaction.equals(tr)) {
                throw new BadRequestException("Transaction " + transaction.getId() + "is already exist");
            }
        }

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transaction;
            }
            index++;
        }
        throw new InternalServerException("There is no free space to save transaction. Transaction " + transaction.getId() + " can't be saved");

//        for(Transaction tr : transactions) {
//            if (tr == null) {
//                break;
//            } else index++;
//        }
//        transactions[index] = transaction;
//        return transactions[index];
    }

    public Transaction[] transactionList() throws Exception{
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                index++;
            }
        }
        if (index > 0) {
            Transaction[] trans = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if (transaction != null) {
                    trans[counter] = transaction;
                }
                counter++;
            }
            return trans;
        } else throw new InternalServerException("Transaction list is empty");

    }

    public Transaction[] transactionList(String city) throws Exception {

        for (int i = 0; i < utils.getCities().length; i++) {
            if (city == utils.getCities()[i]) break;
            if (i + 1 == utils.getCities().length && city != utils.getCities()[i]) {
                throw new BadRequestException("Incorrect city for transaction " + city);
            }
        }

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr.getCity() == city) index++;
        }
        if (index > 0) {
            Transaction[] transactionsByCity = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if (transaction.getCity() == city) {
                    transactionsByCity[counter] = transaction;
                }
                counter++;
            }
            return transactionsByCity;
        } else {
            throw new BadRequestException("No transaction from " + city);
        }
    }

    public Transaction[] transactionList(int amount) throws Exception{

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount) index++;
        }
        if (index > 0) {
            Transaction[] transactionsByAmount = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if (transaction.getAmount() == amount) {
                    transactionsByAmount[counter] = transaction;
                }
                counter++;
            }
            return transactionsByAmount;
        } else {
            throw new BadRequestException("Transactions with this " + amount + " are not found.");
        }

    }

    private void validate(Transaction transaction) throws Exception {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;

        for (Transaction tr : getTransactionPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count >= utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }

        for (int i = 0; i < transactions.length; i++) {
            if (i + 1 == transactions.length && transactions[i] != null) {
                throw new InternalServerException("Transaction " + transaction.getId() + " can't be saved. No free space.");
            }
            if (transactions[i] == null) break;
        }
        for (int i = 0; i < utils.getCities().length; i++) {
            if (transaction.getCity() == utils.getCities()[i]) break;
            if (i + 1 == utils.getCities().length && transaction.getCity() != utils.getCities()[i]) {
                throw new BadRequestException("Incorrect city for transaction " + transaction.getId());
            }
        }
    }

    private void checkTransactionCity(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity()))
                return;
        }

        throw new BadRequestException("Transaction cannot be made from city " + transaction.getCity() + ". Transaction " + transaction.getId() + " can't be saved");
    }

    private Transaction[] getTransactionPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

}
