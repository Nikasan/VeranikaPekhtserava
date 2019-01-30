package hw2_2.hw2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

// TODO What is the purpose of current implementation of hw2?
public class DriverClass {
    // TODO empty line missing
    // TODO Why you decide use here RemoteWebDriver?
    private RemoteWebDriver rwd;

    // TODO Please try avoid abbreviation in methods name
    public RemoteWebDriver getRwd() {
        // TODO missed space between if & ( and {} brace
        // TODO What do you want get from the current realisation?
        if(this.rwd == null) rwd = new ChromeDriver();

        return this.rwd;
    }

}
