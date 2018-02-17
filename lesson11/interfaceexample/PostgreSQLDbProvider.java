package lesson11.interfaceexample;

public class PostgreSQLDbProvider implements DbProvider {
    @Override
    public void connectToDb() {
        //logic to connect
    }

    @Override
    public void disconnectFromDb() {
        //logic to disconnect

    }

    @Override
    public void encryptData() {

    }
}
