package hw6.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import hw6.enums.elements.Buttons;
import hw6.enums.elements.CheckBoxes;
import hw6.enums.elements.Colors;
import hw6.enums.elements.RadioButtons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;

public class DifferentElementPage {
    private static final int checkBoxesAmount = 4;
    private static final int radioButtonsAmount = 4;
    private static final int buttonsAmount = 2;

    @FindBy(css = "div#mCSB_2_container li")
    public ElementsCollection log;

    @FindBy(css = ".checkbox-row input[type = 'checkbox']")
    private ElementsCollection checkBoxesBoard;

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxLabels;

    @FindBy(css = ".checkbox-row input[type = 'radio']")
    private ElementsCollection radioButtonsBoard;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radiobuttonLabels;

    @FindBy(css = ".main-content-hg button, input[type = 'button']")
    private ElementsCollection buttonsBoard;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement fixPanel;

    @FindBy(css = ".uui-side-bar[name = 'navigation-sidebar']")
    private SelenideElement navBar;

    @FindBy(css = ".main-content-hg .colors select")
    private SelenideElement dropDownEntryMode;

    @FindBy(css = ".main-content-hg .colors select option")
    private ElementsCollection dropDownElements;

    public void checkCheckBoxesElements(List<CheckBoxes> checkBoxes) {
        checkBoxesBoard.shouldHaveSize(checkBoxesAmount);
        for (int i = 0; i < checkBoxesAmount; i++) {
            checkBoxesBoard.get(i).exists();
            checkboxLabels.get(i).shouldHave(text(checkBoxes.get(i).toString()));
        }
    }

    public void checkRadioButtonsElements(List<RadioButtons> radioButtons) {
        radioButtonsBoard.shouldHaveSize(radioButtonsAmount);
        for (int i = 0; i < radioButtonsAmount; i++) {
            radioButtonsBoard.get(i).exists();
            radiobuttonLabels.get(i).shouldHave(text(radioButtons.get(i).toString()));
        }
    }


    public void checkDropDownMenuIsPresent() {
        dropDownEntryMode.should(Condition.visible);
    }

    public void checkButtons(List<Buttons> buttons) {
        buttonsBoard.shouldHaveSize(buttonsAmount);
        for (Buttons button : buttons) {
            buttonsBoard.get(button.ordinal()).shouldBe(Condition.visible);
        }
    }

    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

    public void selectCheckboxElement(List<CheckBoxes> elements) {
        for (CheckBoxes element : elements) {
            checkBoxesBoard.get(element.ordinal()).click();
            checkBoxesBoard.get(element.ordinal()).isSelected();
        }
    }

    public void checkLogForForcesOfNature(DataTable table) {
        List<List<String>> data = table.raw();
        for (int i = 0; i < data.size(); i++) {
            log.findBy(text(data.get(i).get(0))).shouldHave(text(data.get(i).get(1)));
        }
    }

    public void assertForcesOfNatureAreUnselected(List<CheckBoxes> elements) {
        for (CheckBoxes element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString()));
            checkBoxesBoard.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void selectRadioElement(RadioButtons radioButton) {
        radioButtonsBoard.get(radioButton.ordinal()).click();
        radioButtonsBoard.get(radioButton.ordinal()).isSelected();
    }

    public void verifyRadioButtonLogRow(RadioButtons radioButton) {
        log.get(0).shouldHave(text("metal: value changed to " + radioButton));
    }

    public void selectDropDownElement(Colors expectedColor) {
        dropDownEntryMode.click();
        dropDownElements.get(expectedColor.ordinal()).click();
        dropDownElements.get(expectedColor.ordinal()).shouldBe(checked);
    }

    public void verifyDropDownElementLogRow(Colors color) {
        log.get(0).shouldHave(text("Colors: value changed to " + color));
    }
}
