package hw2_2.hw2;

public class DriverFactory {
    public static DriverClass createInstance() {
        DriverClass driver = new DriverClass();
        return driver;
    }
}
