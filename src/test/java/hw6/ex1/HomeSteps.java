//package hw6.ex1;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import hw6.ex1.enums.BenefitsTextList;
//import hw6.ex1.enums.ServiceTabOptions;
//import hw6.ex1.enums.User;
//import hw6.ex1.page.objects.HomePage;
//
//import static com.codeborne.selenide.Selenide.page;
//import static hw6.ex1.enums.HomePageInfo.*;
//
//// TODO What is the principle of split test step definition?
//public class HomeSteps {
//    // TODO Please try to think how to passing on pages between steps
//    private HomePage homePage = page(HomePage.class);
//
//    // TODO Why you decide do not parametrized this step?
//    @Then("^Browser title should be 'HOME_PAGE_TITLE'$")
//    public void browserTitleShouldBeHomePage() {
//        homePage.checkBrowserTitle();
//    }
//
//    @When("^I login as '([^\"]*)'$")
//    public void iLoginAs(User user) {
//        homePage.signIn(user);
//    }
//
//    @Then("^Username should be '([^\"]*)'$")
//    public void usernameAssertion(User expectedName) {
//        homePage.checkUserIsLogged(expectedName);
//    }
//
//    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
//    @And("^Home Page should have 4 benefit icons$")
//    public void interfaceIcons() {
//        homePage.checkFourthImages();
//    }
//
//    // TODO What is the text under the icons? How I should guess it from the scenario?
//    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
//    @And("^Home Page should have 4 texts under icons$")
//    public void interfaceShouldHaveTextUnderIcons() {
//        homePage.checkFourTextsUnderBenefitImages(BenefitsTextList.values());
//    }
//
//    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
//    // TODO Why is this method does not parametrized?
//    @And("^Home Page should have title 'Home Page' and description 'LOREM IPSUM..'$")
//    public void homePageShouldHaveTitleHomePageAndDescriptionLOREMIPSUM() {
//        homePage.checkTextOnMainHeaders(MAIN_HEADER_TITLE,MAIN_HEADER_TEXT);
//    }
//
//    // TODO I suppose this step could be parametrized
//    @When("^I click on Service subcategory in the header$")
//    public void iOpenServiceMenuInHeader() {
//        homePage.openServiceFromHeader();
//    }
//
//    // TODO What is the options displayed? How I should guess it from the scenario?
//    @Then("^Service dropdown menu in header displays following options$")
//    public void headerServiceShouldHaveOptions() {
//        homePage.checkNavBarServiceOptions();
//    }
//
//    // TODO This step could be parametrized
//    @When("^I click on Service subcategory in the left section$")
//    public void iOpenServiceMenuInLeftSection() {
//        homePage.openServiceMenuInLeftSection();
//    }
//
//    // TODO What is the options displayed? How I should guess it from the scenario?
//    @Then("^Service dropdown in left section displays following options$")
//    public void leftSideServiceShouldHaveOptions() {
//        homePage.checkSideBarServiceOptions();
//    }
//
//    @When("^I open header menu Service -> '([^\"]*)' Page$")
//    public void iOpenDifferentElementsPage(ServiceTabOptions options) {
//        homePage.openServiceOptions(options);
//    }
//
//}
