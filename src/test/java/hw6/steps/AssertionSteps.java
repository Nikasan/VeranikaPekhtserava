package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.ex3.PageObjects.DifferentElementPage;
import hw6.ex3.PageObjects.HomePage;
import hw6.ex3.PageObjects.UserTablePage;
import hw6.ex3.enums.User;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
  private HomePage homePage = page(HomePage.class);
  private UserTablePage userTablePage = page(UserTablePage.class);
  private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

    @Then("^Browser title should be 'HOME_PAGE_TITLE'$")
    public void checkBrowserTitle() {
        homePage.checkBrowserTitle();
    }

    @Then("^Username should be '([^\"]*)'$")
    public void iLoginAsUserUSER(User user) {
        homePage.checkUserIsLogged(user);
    }



}
