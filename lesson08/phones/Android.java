package lesson08.phones;

public class Android extends Phone {

    String androidVersion;
    int screenSize;

    String secretDeviceCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviceCode) {
        super(price, weight, countryProduced);
        System.out.println("Android constructor was invoked...");

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviceCode = secretDeviceCode;
    }

    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    }

}