package hw6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import static org.openqa.selenium.remote.BrowserType.CHROME;

@CucumberOptions(
        features = {"classpath:hw6"}, tags = {"@DifferentElementsInterface, @UserTableInterface"},
        glue = {"classpath:hw6.ex1", "classpath:hw6.ex2"}
)

public class Runner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuit(){
        Configuration.browser =CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
