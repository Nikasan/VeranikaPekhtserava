package hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


import hw6.ex2.enums.ServiceTabOptions;
import hw6.ex2.enums.User;
import hw6.ex2.page.objects.HomePage;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomeSteps {

    private HomePage homePage = page(HomePage.class);

    @And("^I login as user '([^\"]*)'$")
            public void iLoginAs(User user) {
                homePage.signIn(user);
            }

        @When("^I click on Service button in Header$")
        public void iOpenServiceMenuInHeader() {
            homePage.openServiceFromHeader();
        }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iOpenUserTable(ServiceTabOptions option) {
            homePage.openServiceOptions(option);
        }
    }

