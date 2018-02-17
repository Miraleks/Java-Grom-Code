package lesson11.firstinterface;

public class TestClass implements FirstInterface {

    private int test = 10;


    @Override
    public void sent() {
        //some logic
    }

    @Override
    public String receive() {
        //some logic
        return null;
    }
}
