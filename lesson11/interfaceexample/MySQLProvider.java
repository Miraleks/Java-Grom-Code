package lesson11.interfaceexample;

public class MySQLProvider implements DbProvider {
    @Override
    public void connectToDb() {
        //logic to connect
    }

    @Override
    public void encryptData() {

    }

    public void disconnectFromDb() {

    }

}
