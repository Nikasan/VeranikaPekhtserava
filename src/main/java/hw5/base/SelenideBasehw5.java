package hw5.base;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public abstract class SelenideBasehw5 {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = CHROME;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 500;
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("System.currentTimeMillis())= " + System.currentTimeMillis());
    }
}