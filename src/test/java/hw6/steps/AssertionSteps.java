package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw6.PageObjects.DifferentElementPage;
import hw6.PageObjects.HomePage;
import hw6.PageObjects.UserTablePage;
import hw6.enums.*;
import hw6.enums.elements.Buttons;
import hw6.enums.elements.CheckBoxes;
import hw6.enums.elements.Colors;
import hw6.enums.elements.RadioButtons;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
  private HomePage homePage = page(HomePage.class);
  private UserTablePage userTablePage = page(UserTablePage.class);
  private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

  @Then("^Browser title should be '([^\"]*)'$")
    public void checkBrowserTitle(HomePageInfo title) {
        homePage.checkBrowserTitle(title);
    }

  @Then("^Username should be '([^\"]*)'$")
    public void iLoginAsUserUSER(User user) {
        homePage.checkUserIsLogged(user);
    }

  @Then("^Home Page should have 4 benefit icons$")
  public void homePageShouldHaveBenefitIcons() {
      homePage.checkFourthImages();
  }

  @Then("^Home Page should have 4 texts under benefit icons$")
  public void homePageShouldHaveTextsUnderBenefitIcons() {
      homePage.checkBenefitTexts(BenefitsTextList.values());
  }

  @Then("^Home Page should have title '([^\"]*)' and description '([^\"]*)'$")
  public void assertTitleAndDescription(HomePageInfo header, HomePageInfo text) {
      homePage.checkTextOnMainHeaders(header,text);
  }

    @Then("^Service dropdown menu in header displays options:$")
    public void headerServiceShouldHaveOptions(List<ServiceTabOptions> options) {
        homePage.checkServiceOptionsFromHeader(options);
    }

    @Then("^Service dropdown in left section displays following options:$")
    public void leftServiceShouldHaveOptions(List<ServiceTabOptions> options) {
        homePage.checkSideBarServiceOptions(options);
    }

    @Then("^Interface on Different elements page contains 4 checkboxes with forces of nature:$")
    public void interfaceShouldContainCheckboxes(List<CheckBoxes> checkBoxes) {
        differentElementPage.checkCheckBoxesElements(checkBoxes);
    }

    @And("^Interface on Different elements page contains colors dropdown$")//And==Then in this step
    public void interfaceShouldContainColorDropdown() {
        differentElementPage.checkDropDownMenuIsPresent();
    }

    @And("^Interface on Different elements page contains 4 radio buttons with metals:$") //And==Then in this step
    public void interfaceShouldContainRadioButtons(List<RadioButtons> radioButtons) {
        differentElementPage.checkRadioButtonsElements(radioButtons);
    }

    @And("^Interface on Different elements page contains 2 buttons:$") //And==Then in this step
    public void interfaceContainsButtons(List<Buttons> button) {
        differentElementPage.checkButtons(button);
    }

    @And("^Different elements page has a Right section$")//And==Then in this step
    public void differentElementsPageHasARightSection() {
        differentElementPage.checkFixPaneIsVisible();
    }

    @And("^Different elements page has a Left section$")//And==Then in this step
    public void differentElementsPageHasLeftSection() {
        differentElementPage.checkNavBarIsVisible();
    }

    @Then("^For each checkbox there is a log row with corresponding status$")
    public void logShouldWorkForForcesOfNature(DataTable table) {
        differentElementPage.checkLogForForcesOfNature(table);
    }

    @Then("^Following boxes are unchecked:$")
    public void followingBoxesAreUnchecked(List<CheckBoxes> checkBoxes) {
        differentElementPage.assertForcesOfNatureAreUnselected( checkBoxes);
    }

    @Then("^There is a log raw for '([^\"]*)' radio button$")
    public void logShouldWorkForMetalButton(RadioButtons buttons) {
        differentElementPage.verifyRadioButtonLogRow(buttons);
    }

    @Then("^There is a log raw for '([^\"]*)' color dropdown$")
    public void logShouldWorkForColors(Colors color) {
        differentElementPage.verifyDropDownElementLogRow(color);
    }

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageOpen(UserTablePageInfo title) {
        userTablePage.checkTitle(title);
    }

    @And("^'(\\d+)' NumberType Dropdowns are displayed in Users Table on User Table Page$")//And==Then
    public void numberTypeDropdownsAreDisplayed(int number) {
        userTablePage.checkNumberTypeDropdowns(number);
    }

    @And("^'(\\d+)' User names are displayed in Users Table on User Table Page$")
    public void usersAreDisplayed(int number) {
        userTablePage.checkUsernames(number);
    }

    @And("^'(\\d+)' Description images are displayed in Users Table on User Table Page$")
    public void descriptionImagesAreDisplayed(int number) {
        userTablePage.checkDescriptionImages(number);
    }

    @And("^'(\\d+)' Description texts under images are displayed in Users Table on User Table Page$")
    public void textsUnderImagesAreDisplayed(int number) {
        userTablePage.checkTextsUnderImages(number);
    }

    @And("^'(\\d+)' checkboxes are displayed in Users Table on User Table Page$")
    public void checkboxesStatus(int number) {
        userTablePage.checkVipCheckboxes(number);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsValues(DataTable dataTable) {
        userTablePage.checkUserTableContainsElements(dataTable);
    }

    @Then("^1 log row has '([^\"]*)' text in log section$")
    public void topLogRowsStatus(String message) {
        userTablePage.checkLogForVipBox(message);
    }

    @Then("^Droplist contains values$")
    public void dropdownValues(List<String> values) {
        userTablePage.checkUserRoleDropdownHasValues(values);
    }
}
