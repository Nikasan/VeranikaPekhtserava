package hw5.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw5.enums.different_elements_page.CheckBoxes;
import hw5.enums.different_elements_page.Colors;
import hw5.enums.different_elements_page.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.checked;

public class DifferentElementPage {
    private static final int checkBoxesAmount = 4;
    private static final int radioButtonsAmount = 4;
    private static final int buttonsAmount = 2;

    @FindBy(css = ".checkbox-row input[type = 'checkbox']")
    private ElementsCollection checkBoxesBoard;

    @FindBy(css = ".checkbox-row input[type = 'radio']")
    private ElementsCollection radioButtonsBoard;

    @FindBy(css = ".main-content-hg button, input[type = 'button']")
    private ElementsCollection buttonsBoard;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement fixPanel;

    @FindBy(css = ".uui-side-bar[name = 'navigation-sidebar']")
    private SelenideElement navBar;

    @FindBy(css = "div#mCSB_2_container li")
    public ElementsCollection log;

    @FindBy(css = ".main-content-hg .colors select")
    private SelenideElement dropDownEntryMode;

    @FindBy(css = ".main-content-hg .colors select option")
    private ElementsCollection dropDownElements;

   @Step("Check count of check boxes")
    public void checkNumberOfCheckBoxElements() {
        checkBoxesBoard.shouldHaveSize(checkBoxesAmount);
    }

    @Step("Check count of radioButtons")
    public void checkNumberOfRadioButtonElements() {
        radioButtonsBoard.shouldHaveSize(radioButtonsAmount);
    }

    @Step("Check count of buttons")
    public void checkNumberOfButtonsElements() {
        buttonsBoard.shouldHaveSize(buttonsAmount);
    }

    @Step("Check that drop-down with colors options is present")
    public void checkDropDownMenuIsPresent() {
        dropDownEntryMode.should(Condition.visible);
    }

    @Step("Check that right fix panel is present")
    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    @Step("Check that navigation bar is present on the left page side")
    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

    @Step("Select check-box {index}")
    public void selectCheckboxElement(int index) {
        checkBoxesBoard.get(index).click();
    }

    @Step("Check log row for check-box {checkBox}")
    public void verifyCheckBoxLogRow(CheckBoxes checkBox, boolean action) {
        log.get(0).shouldHave(Condition.text(checkBox.checkBox + ": condition changed to " + action));
    }

    @Step("Select metal radio button {index}")
    public void selectRadioElement(int index) {
        radioButtonsBoard.get(index).click();
    }

    @Step("Check log row for {radioButton} ")
    public void verifyRadioButtonLogRow(RadioButtons radioButton) {
        log.get(0).shouldHave(Condition.text("metal: value changed to " + radioButton));
    }

    @Step("Select color {expectedColor} from drop-down panel ")
    public void selectDropDownElement(Colors expectedColor) {
        dropDownEntryMode.click();
        dropDownElements.get(expectedColor.ordinal()).click();
        dropDownElements.get(expectedColor.ordinal()).shouldBe(checked);
    }

    @Step("Check log row for {color}")
    public void verifyDropDownElementLogRow(Colors color) {
        log.get(0).shouldHave(Condition.text("Colors: value changed to " + color));
    }
}