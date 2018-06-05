package a_test;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            throw new Exception("Hello ");
        } catch (IOException e){
            System.out.print(e.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }finally {
            System.out.println("World");
        }
    }
}
