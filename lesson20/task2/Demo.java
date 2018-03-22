package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction tr1 = new Transaction(11001100, "Odessa", 20, "salary", TransactionType.INCOME, new Date());
        Transaction tr2 = new Transaction(11001100, "Odessa", 20, "salary", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(11001100, "Odessa", 20, "salary", TransactionType.INCOME, new Date());


        Controller controller = new Controller();

        try {
            System.out.println(controller.save(tr1));
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            System.out.println(controller.transactionList());
        }catch (Exception e){
            System.out.println("Method transactionList return exception: " + e);
        }

        try{
            controller.transactionList("Odessa");
        }catch (Exception e){
            System.out.println("Method transactionList(city) return exception: " + e);
        }
        try{
            controller.transactionList(20);
        }catch (Exception e){
            System.out.println("Method transactionList(amount) return exception: " + e);
        }






    }
}
