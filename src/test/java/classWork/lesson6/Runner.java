package classWork.lesson6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

@CucumberOptions(
        features = "classpath:lesson6",
        glue = "classpath:classWork.lesson6.Steps"
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuit(){
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
