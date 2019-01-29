package hw2_2.hw2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverClass {
    private RemoteWebDriver rwd;


    public RemoteWebDriver getRwd() {
        if(this.rwd == null) rwd = new ChromeDriver();

        return this.rwd;
    }

}
