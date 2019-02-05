package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static java.lang.System.setProperty;

public class SeleniumBase {
private long time;

    @BeforeSuite (alwaysRun=true)
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = System.currentTimeMillis();
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println(System.currentTimeMillis()-time);
        }
}

// @BeforeSuite (alwaysRun=true) will be executed before any tests declared inside a TestNG suite. In my case I don't have a suit,
// but if suit will be created,
// we wouldn't need to specify the path to the driver in each test-method.
// I add variable time = System.currentTimeMillis(); it counts time, when our method started

//@AfterSuite will be executed after any tests declared inside a TestNG suite.
// System.currentTimeMillis()-time  This method count how long our tests had been working.
