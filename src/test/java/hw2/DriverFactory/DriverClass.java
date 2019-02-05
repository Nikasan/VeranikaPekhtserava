package hw2.DriverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverClass {

    private RemoteWebDriver rwd;

    public RemoteWebDriver getRemoteWebDriver() {
        if (this.rwd == null) {
            rwd = new ChromeDriver();
        }

        return this.rwd;
    }
}

//I use RemoteWebDriver because it can run my tests on a separate machines.
//It allows you to run lots of tests on lots of OS’s and lots of browsers without having to actually maintain or install any of them
// (Linux, Windows 8, Windows 10, MacOS, Andriod, IOS, IE, Firefox, Opera, Safari, Firefox Mobile, etc) You’ll want to look into running tests
// asynchronously at this point. You don’t have to run them one at a time, so can test a large number of OS/Browser variations in a very short time.