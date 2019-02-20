package hw6.ex1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.ex1.enums.BenefitsTextList;
import hw6.ex1.enums.ServiceTabOptions;
import hw6.ex1.enums.User;
import hw6.ex1.page.objects.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static hw6.ex1.enums.HomePageInfo.*;

public class HomeSteps {
    private HomePage homePage = page(HomePage.class);

    @Then("^Browser title should be 'HOME_PAGE_TITLE'$")
    public void browserTitleShouldBeHOME_PAGE_TITLE() {
        homePage.checkBrowserTitle();
    }

    @When("^I login as '([^\"]*)'$")
    public void iLoginAs(User user) {
        homePage.signIn(user);
    }

    @Then("^Username should be '([^\"]*)'$")
    public void usernameShouldBe(User expectedName) {
        homePage.checkUserIsLogged(expectedName);
    }

    @And("^Home Page should have 4 benefit icons$")
    public void interfaceShouldHaveIcons() {
        homePage.checkFourthImages();
    }

    @And("^Home Page should have 4 texts under icons$")
    public void interfaceShouldHaveTextUnderIcons() {
        homePage.checkFourTextsUnderBenefitImages(BenefitsTextList.values());
    }

    @And("^Home Page should have title 'Home Page' and description 'LOREM IPSUM..'$")
    public void homePageShouldHaveTitleHomePageAndDescriptionLOREMIPSUM() {
        homePage.checkTextOnMainHeaders(MAIN_HEADER_TITLE,MAIN_HEADER_TEXT);
    }

    @When("^I click on Service subcategory in the header$")
    public void iOpenServiceMenuInHeader() {
        homePage.openServiceFromHeader();
    }

    @Then("^Service dropdown menu in header displays following options$")
    public void headerServiceShouldHaveOptions() {
        homePage.checkNavBarServiceOptions();
    }

    @When("^I click on Service subcategory in the left section$")
    public void iOpenServiceMenuInLeftSection() {
        homePage.openServiceMenuInLeftSection();
    }

    @Then("^Service dropdown in left section displays following options$")
    public void leftSideServiceShouldHaveOptions() {
        homePage.checkSideBarServiceOptions();
    }

    @When("^I open header menu Service -> '([^\"]*)' Page$")
    public void iOpenDifferentElementsPage(ServiceTabOptions options) {
        homePage.openServiceOptions(options);
    }

}
