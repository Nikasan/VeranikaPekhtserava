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

// TODO What is the principle of split test step definition?
public class DiffSteps {
    // TODO Please try to think how to passing on pages between steps
    private DifferentElementPage diffElemPage = page(DifferentElementPage.class);

    // TODO Please thinks about better step description
    // TODO Which forces of nature should be present on th page
    @Then("^Interface on Different elements page contains 4 checkboxes with forces of nature$")
    public void interfaceShouldContainCheckboxes() {
        diffElemPage.checkNumberOfCheckBoxElements();
    }

    // TODO Please thinks about better step description
    // TODO Which metals should be present on th page
    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
    @And("^Interface on Different elements page contains 4 radio buttons with metals$")
    public void interfaceShouldContainRadioButtons() {
        diffElemPage.checkNumberOfRadioButtonElements();
    }

    // TODO Please thinks about better step description
    // TODO Which metals should be present on th page
    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
    @And("^Interface on Different elements page contains color choice dropdown$")
    public void interfaceShouldContainColorDropdown() {
        diffElemPage.checkDropDownMenuIsPresent();
    }

    // TODO Please thinks about better step description
    // TODO Which buttons should be present on th page
    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
    @And("^Interface on Different elements page contains 2 buttons$")
    public void interfaceShouldHaveButtons() {
        diffElemPage.checkNumberOfButtonsElements();
    }

    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
    @And("^Different elements page has a Right section$")
    public void differentElementsPageShouldHaveRightSection() {
        diffElemPage.checkFixPaneIsVisible();
    }

    // TODO What does 'And' means? Is it 'When' or 'Given' or 'Then'
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

    // TODO This step could be combine into one with "I select '([^"]*)' checkbox on Different elements page"
    @When("^I unselect '([^\"]*)' checkbox on Different elements page$")
    public void unSelectWind(List<CheckBoxes> elements) {
            diffElemPage.selectCheckboxElement(elements);
    }

    // TODO What is the purpose of current step?
    @Then("checkbox = WIND and action = false")
    public void forWINDCheckboxThereIsALogRowWithCorrespondingStatusFalse(CheckBoxes elements, boolean action) {
        diffElemPage.verifyCheckBoxLogRow(elements, action);
    }
}

