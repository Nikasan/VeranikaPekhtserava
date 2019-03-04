//package hw6.ex2;
//
//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import hw6.ex2.page.objects.UserTablePage;
//import hw6.ex2.enums.TableNames;
//import hw6.ex2.enums.UserTablePageInfo;
//
//import java.util.List;
//
//import static com.codeborne.selenide.Selenide.page;
//
//public class UserTablePageSteps {
//    private UserTablePage userTablePage = page(UserTablePage.class);
//
//    @Then("^'([^\"]*)' page is opened$")
//    public void userTablePageOpen(UserTablePageInfo title) {
//        userTablePage.checkTitle(title);
//    }
//
//    @And("^'(\\d+)' NumberType Dropdowns are displayed in Users Table on User Table Page$")
//    public void numberTypeDropdownsAreDisplayed(int number) {
//        userTablePage.checkNumberTypeDropdowns(number);
//    }
//
//    @And("^'(\\d+)' User names are displayed in Users Table on User Table Page$")
//    public void usernamesAreDisplayed(int number) {
//        userTablePage.checkUsernames(number);
//    }
//
//    @And("^'(\\d+)' Description images are displayed in Users Table on User Table Page$")
//    public void descriptionImagesAreDisplayed(int number) {
//        userTablePage.checkDescriptionImages(number);
//    }
//
//    @And("^'(\\d+)' Description texts under images are displayed in Users Table on User Table Page$")
//    public void textsUnderImagesAreDisplayed(int number) {
//        userTablePage.checkTextsUnderImages(number);
//    }
//
//    @And("^'(\\d+)' checkboxes are displayed in Users Table on User Table Page$")
//    public void checkboxesStatus(int number) {
//        userTablePage.checkVipCheckboxes(number);
//    }
//
//    @Then("^User table contains following values:$")
//    public void userTableContainsValues(DataTable dataTable) {
//        userTablePage.checkUserTableContainsElements(dataTable);
//    }
//
//    // TODO Is it possible parametrized step?
//    @When("^I select 'vip' checkbox for '([^\"]*)'$")
//    public void selectVipCheckbox(TableNames name) {
//        userTablePage.selectVipBox(name);
//    }
//
//    // TODO I think you have already had method which check log
//    @Then("^1 log row has '([^\"]*)' text in log section$")
//    public void topLogRowsStatus(String message) {
//        userTablePage.checkLogForVipBox(message);
//    }
//
//    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
//    public void clickOnColumnType(TableNames name) {
//        userTablePage.openDropdownColumnTypeForUser(name);
//    }
//
//    @Then("^Droplist contains values$")
//    public void dropdownValues(List<String> values) {
//        userTablePage.checkDropdownHasValues(values);
//    }
//}
