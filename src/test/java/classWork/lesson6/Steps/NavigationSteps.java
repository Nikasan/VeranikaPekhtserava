package classWork.lesson6.Steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static hw6.ex1.enums.HomePageInfo.HOME_PAGE_URL;

public class NavigationSteps {


    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
            open(HOME_PAGE_URL.value);
        }
    }