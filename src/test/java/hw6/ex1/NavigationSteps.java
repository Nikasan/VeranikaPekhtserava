package hw6.ex1;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw6.ex1.enums.HomePageInfo.HOME_PAGE_URL;

public class NavigationSteps {

    @Given("^I open EPAM JDI site$")
    public void openSite() {
        open(HOME_PAGE_URL.value);
        getWebDriver().manage().window().maximize();
    }

    @After
    public void driverClose() {
        close();
    }
}