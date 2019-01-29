package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class SeleniumBase {
    @BeforeSuite (alwaysRun=true)
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    }



}
