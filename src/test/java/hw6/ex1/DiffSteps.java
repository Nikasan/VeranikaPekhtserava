package hw6.ex1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.ex1.enums.different.elements.CheckBoxes;
import hw6.ex1.enums.different.elements.Colors;
import hw6.ex1.enums.different.elements.RadioButtons;
import hw6.ex1.page.objects.DifferentElementPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class DiffSteps {
    private DifferentElementPage diffElemPage = page(DifferentElementPage.class);

    @Then("^Interface on Different elements page contains 4 checkboxes with forces of nature$")
    public void interfaceShouldContainCheckboxes() {
        diffElemPage.checkNumberOfCheckBoxElements();
    }

    @And("^Interface on Different elements page contains 4 radio buttons with metals$")
    public void interfaceShouldContainRadioButtons() {
        diffElemPage.checkNumberOfRadioButtonElements();
    }

    @And("^Interface on Different elements page contains color choice dropdown$")
    public void interfaceShouldContainColorDropdown() {
        diffElemPage.checkDropDownMenuIsPresent();
    }

    @And("^Interface on Different elements page contains 2 buttons$")
    public void interfaceShouldHaveButtons() {
        diffElemPage.checkNumberOfButtonsElements();
    }

    @And("^Different elements page has a Right section$")
    public void differentElementsPageShouldHaveRightSection() {
        diffElemPage.checkFixPaneIsVisible();
    }

    @And("^Different elements page has a Left section$")
    public void differentElementsPageShouldHaveLeftSection() {
        diffElemPage.checkNavBarIsVisible();
    }

    @When("^I select '([^\"]*)' checkbox with forces of nature on Different elements page$")
    public void iSelectWATERCheckboxesWithForcesOfNatureOnDifferentElementsPage(List<CheckBoxes> elements) {
        diffElemPage.selectCheckboxElement(elements);
    }

    @Then("^For '([^\"]*)' checkbox there is a log row with corresponding status '([^\"]*)'$")
    public void forWATERCheckboxThereIsALogRowWithCorrespondingStatus(CheckBoxes elements, boolean action) {
        diffElemPage.verifyCheckBoxLogRow(elements, action);
    }

    @When("^I select '([^\"]*)' checkbox on Different elements page$")
    public void iSelectWINDCheckboxWithForcesOfNatureOnDifferentElementsPage(List<CheckBoxes> elements) {
        diffElemPage.selectCheckboxElement(elements);
    }

    @Then("^For '([^\"]*)' checkbox there is a log row with status '([^\"]*)'$")
    public void forWINDCheckboxThereIsALogRowWithCorrespondingStatusTrue(CheckBoxes elements, boolean action) {
        diffElemPage.verifyCheckBoxLogRow(elements, action);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void iSelectRadioButton(RadioButtons buttons) {
        diffElemPage.selectRadioElement(buttons);
    }

    @Then("^There is a log raw for '([^\"]*)' radio button$")
    public void logShouldWorkForMetalButton(RadioButtons buttons) {
        diffElemPage.verifyRadioButtonLogRow(buttons);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void iSelectColor(Colors color) {
        diffElemPage.selectDropDownElement(color);
    }

    @Then("^There is a log raw for '([^\"]*)' color dropdown$")
    public void logShouldWorkForColors(Colors color) {
        diffElemPage.verifyDropDownElementLogRow(color);
    }

    @When("^I unselect '([^\"]*)' checkbox with forces of nature on Different elements page$")
    public void iUnselectCheckboxWATER(List<CheckBoxes> elements) {
        diffElemPage.selectCheckboxElement(elements);
    }


    @Then("^Log row For '([^\"]*)' checkbox with status '([^\"]*)'$")
    public void forWATERCheckboxThereIsALogRowWithCorrespondingStatusFalse(CheckBoxes elements, boolean action) {
        diffElemPage.verifyCheckBoxLogRow(elements, action);
    }

    @When("^I unselect '([^\"]*)' checkbox on Different elements page$")
    public void unSelectWind(List<CheckBoxes> elements) {
            diffElemPage.selectCheckboxElement(elements);
    }

    @Then("checkbox = WIND and action = false")
    public void forWINDCheckboxThereIsALogRowWithCorrespondingStatusFalse(CheckBoxes elements, boolean action) {
        diffElemPage.verifyCheckBoxLogRow(elements, action);
    }
}

