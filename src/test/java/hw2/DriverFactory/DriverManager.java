package hw2.DriverFactory;

public class DriverManager {

    private static ThreadLocal<DriverClass> driver = new ThreadLocal<DriverClass>();

    public static DriverClass getDriver() {
        return driver.get();
    }

    public static void setDriver(DriverClass drive) {
        driver.set(drive);
    }
}
