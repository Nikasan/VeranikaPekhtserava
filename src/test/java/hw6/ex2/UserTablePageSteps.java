package hw6.ex2;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.ex2.page.objects.HomePage;
import hw6.ex2.page.objects.UserTablePage;
import hw6.ex2.enums.TableNames;
import hw6.ex2.enums.UserTablePageInfo;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class UserTablePageSteps {
    private UserTablePage userTablePage = page(UserTablePage.class);
    private HomePage homePage = page(HomePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(UserTablePageInfo title) {
        userTablePage.checkTitle(title);
    }

    @And("^'(\\d+)' NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numberTypeDropdownsAreDisplayed(int number) {
        userTablePage.checkNumberTypeDropdowns(number);
    }

    @And("^'(\\d+)' User names are displayed on Users Table on User Table Page$")
    public void usernamesAreDisplayed(int number) {
        userTablePage.checkUsernames(number);
    }

    @And("^'(\\d+)' Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayed(int number) {
        userTablePage.checkDescriptionImages(number);
    }

    @And("^'(\\d+)' Description texts under images are displayed on Users Table on User Table Page$")
    public void textsUnderImagesAreDisplayed(int number) {
        userTablePage.checkTextsUnderImages(number);
    }

    @And("^'(\\d+)' checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayed(int number) {
        userTablePage.checkVipCheckboxes(number);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsValues(DataTable dataTable) {
        userTablePage.checkUserTableContainsElements(dataTable);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckbox(TableNames name) {
        userTablePage.selectVipBox(name);
    }

    @Then("^1 log row has '([^\"]*)' text in log section$")
    public void topLogRowShowsChangeOfStatus(String message) {
        userTablePage.checkLogForVipBox(message);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnColumnTypeForUser(TableNames name) {
        userTablePage.openDropdownColumnTypeForUser(name);
    }

    @Then("^Droplist contains values$")
    public void dropdownContainsValues(List<String> values) {
        userTablePage.checkDropdownHasValues(values);
    }
}
