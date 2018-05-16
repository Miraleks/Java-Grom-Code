package lesson19;

public class ThrowExample {
    private static String[] array = {"a_test", "test1", "test2", null, "test3", "test4"};

    public static void main(String[] args) {
        //a_test();

        useOfTestMethod();
    }

    private static void test(){
        for(String element : array){
            if(element == null){
                throw new RuntimeException("null is detected");
            }
        }
        System.out.println("done");


    }

    private static void useOfTestMethod(){
        try {
            //some code
            test();
            //some code
        }catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
    }

}
