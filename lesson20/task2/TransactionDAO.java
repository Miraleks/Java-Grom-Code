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

        if(transactions == null) return null;

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

    }

    public Transaction[] transactionList() throws Exception{

        if(transactions == null) return null;
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                index++;
            }
        }

            Transaction[] trans = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if (transaction != null) {
                    trans[counter] = transaction;
                }
                counter++;
            }
            return trans;


    }

    public Transaction[] transactionList(String city) throws Exception {

        if(transactions == null || utils == null) throw new NullPointerException("Null data in sort by city is detected");

        if(city == null) throw new NullPointerException("Null data in sort by city is detected");

//        for (int i = 0; i < utils.getCities().length; i++) {
//            if (city.equals(utils.getCities()[i])) break;
//
//            if (i + 1 == utils.getCities().length && !(utils.getCities()[i].equals(city))) {
//                throw new BadRequestException("Incorrect city for transaction " + city);
//            }
//        }

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null){
                if(tr.getCity().equals(city)) index++;
            }
        }

            Transaction[] transactionsByCity = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if(transaction != null) {
                    if (transaction.getCity().equals(city)) {
                        transactionsByCity[counter] = transaction;
                    }
                    counter++;
                }
            }
            return transactionsByCity;

    }

    public Transaction[] transactionList(int amount) throws Exception{

        if(transactions == null || amount == 0) return null;

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) index++;
        }

            Transaction[] transactionsByAmount = new Transaction[index];
            int counter = 0;
            for (Transaction transaction : transactions) {
                if (transaction != null && transaction.getAmount() == amount) {
                    transactionsByAmount[counter] = transaction;
                }
                counter++;
            }
            return transactionsByAmount;


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
