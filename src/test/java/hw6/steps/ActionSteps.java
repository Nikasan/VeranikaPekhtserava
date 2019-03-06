package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw6.PageObjects.DifferentElementPage;
import hw6.PageObjects.HomePage;
import hw6.PageObjects.UserTablePage;
import hw6.enums.ServiceTabOptions;
import hw6.enums.TableNames;
import hw6.enums.User;
import hw6.enums.elements.CheckBoxes;
import hw6.enums.elements.Colors;
import hw6.enums.elements.RadioButtons;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private HomePage homePage = page(HomePage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);
    private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

    @When("^I login as '([^\"]*)'$")
    public void login(User user) {
        homePage.signIn(user);
    }

    @When("^I open Service dropdown from header$")
    public void openServiceMenuFromHeader() {
        homePage.openSrviceDropdownFromHeader();
    }

    @When("^I click on Service subcategory in the left section$")
    public void openServiceMenuFromLeftSection() {
        homePage.openServiceMenuInLeftSection();
    }

    @When("^I open '([^\"]*)' page from header menu Service$")
    public void openDifferentElementsPageFromHeader(ServiceTabOptions option) {
        homePage.openServiceOptions(option);
    }

    @When("^I select following checkboxes with forces of nature on Different elements page:$")
    public void selectNatureElements(List<CheckBoxes> natureElements) {
        differentElementPage.selectCheckboxElement(natureElements);
    }

    @When("^I unselect checkboxes:$")
    public void unselectNatureElements(List<CheckBoxes> natureElements) {
        differentElementPage.selectCheckboxElement(natureElements);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void selectMetalElements(RadioButtons buttons) {
        differentElementPage.selectRadioElement(buttons);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void selectColor(Colors color) {
        differentElementPage.selectDropDownElement(color);
    }

    @And("^I click on '([^\"]*)' option in Service dropdown$") //And==When
    public void openUserTableFromHeaderService(ServiceTabOptions option) {
        homePage.openServiceOptions(option);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void selectVipCheckbox(TableNames name) {
        userTablePage.selectVipBox(name);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void clickOnColumnType(TableNames name) {
        userTablePage.openDropdownColumnTypeForUser(name);
    }
}

