package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception{
        int index = 0;

        if (transaction == null) {
            throw new NullPointerException("null data is detected");
        }

        validate(transaction);

        for(Transaction tr : transactions){
            if(tr == null){
                break;
            }else index++;
        }
        transactions[index] = transaction;
        return transactions[index];

    }



    Transaction[] transactionList() {




        return null;

    }

    Transaction[] transactionList(String city){


        return null;

    }

    Transaction[] transactionList(int amount){



        return null;

    }

    private void validate(Transaction transaction) throws Exception {

        if(transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed "+ transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        boolean freeSpaceFlag = false;
        boolean cityCheckFlag = false;

        for(Transaction tr : getTransactionPerDay(transaction.getDateCreated())){
            sum += tr.getAmount();
            count++;
        }

        if(sum > utils.getLimitTransactionsPerDayAmount()){
            throw new LimitExceeded("Transaction limit per day amount exceed "+ transaction.getId() + ". Can't be saved");
        }

        if(count > utils.getLimitTransactionsPerDayCount()){
            throw new LimitExceeded("Transaction limit per day count exceed "+ transaction.getId() + ". Can't be saved");
        }

        for(Transaction tr : transactions){
            if(tr == null) freeSpaceFlag = true;
        }
        if(freeSpaceFlag == false){
            throw new InternalServerException("Transaction " + transaction.getId() + " can't be saved. No free space.");
        }
        for(String cities: utils.getCities()){
            if(cities == transaction.getCity()){
                cityCheckFlag = true;
            }
        }
        if(cityCheckFlag == false){
            throw new BadRequestException("Incorrect city for transaction " + transaction.getId());
        }
    }

    private Transaction[] getTransactionPerDay(Date dateOfCurTransaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for(Transaction transaction : transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth == month && trDay == day){
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

}
