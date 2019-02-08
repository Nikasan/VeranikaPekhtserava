package classWork.lesson6.Steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {
    public final static String URL = "https://epam.github.io/JDI/index.html";

    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
            open(URL);
        }
    }