package hw6.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import hw6.ex3.PageObjects.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw6.ex3.enums.HomePageInfo.HOME_PAGE_URL;

public class NavigationSteps1 {
    private HomePage homePage;

    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
        open(HOME_PAGE_URL.value);
        homePage = page(HomePage.class);
        getWebDriver().manage().window().maximize();
    }

    @After
    public void driverClose() {
        close();
    }
}
