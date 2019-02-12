package hw4.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.different_elements_page.CheckBoxes;
import hw4.enums.different_elements_page.Colors;
import hw4.enums.different_elements_page.RadioButtons;
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

    public void checkNumberOfCheckBoxElements() {
        checkBoxesBoard.shouldHaveSize(checkBoxesAmount);
    }

    public void checkNumberOfRadioButtonElements() {
        radioButtonsBoard.shouldHaveSize(radioButtonsAmount);
    }

    public void checkDropDownMenuIsPresent() {
        dropDownEntryMode.should(Condition.visible);
    }

    public void checkNumberOfButtonsElements() {
        buttonsBoard.shouldHaveSize(buttonsAmount);
    }

    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

   public void selectCheckboxElement(CheckBoxes checkBoxes){
        checkBoxesBoard.get(checkBoxes.ordinal()).click();
        checkBoxesBoard.get(checkBoxes.ordinal()).isSelected();
   }

    public void verifyCheckBoxLogRow(CheckBoxes checkBoxes, boolean action) {
        log.get(0).shouldHave(Condition.text(checkBoxes.checkBox + ": condition changed to " + action));
    }

    public void selectRadioElement(RadioButtons radioButton){
        radioButtonsBoard.get(radioButton.ordinal()).click();
        radioButtonsBoard.get(radioButton.ordinal()).isSelected();
    }

    public void verifyRadioButtonLogRow(RadioButtons radioButton) {
        log.get(0).shouldHave(Condition.text("metal: value changed to " + radioButton));
    }

    public void selectDropDownElement(Colors expectedColor) {
        dropDownEntryMode.click();
        dropDownElements.get(expectedColor.ordinal()).click();
        dropDownElements.get(expectedColor.ordinal()).shouldBe(checked);
    }

    public void verifyDropDownElementLogRow(Colors color) {
        log.get(0).shouldHave(Condition.text("Colors: value changed to " + color));
    }
}