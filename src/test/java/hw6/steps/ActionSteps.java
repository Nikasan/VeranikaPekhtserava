package hw6.steps;

import cucumber.api.java.en.When;
import hw6.ex3.PageObjects.DifferentElementPage;
import hw6.ex3.PageObjects.HomePage;
import hw6.ex3.PageObjects.UserTablePage;
import hw6.ex3.enums.User;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private HomePage homePage = page(HomePage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);
    private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

    @When("^I login as '([^\"]*)'$")
    public void iLoginAsUSER(User user) {
        homePage.signIn(user);
    }


}
