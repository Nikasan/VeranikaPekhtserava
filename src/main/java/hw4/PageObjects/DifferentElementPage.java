package hw4.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.ServiceTabOptions;
import hw4.Enums.differentElementsPage.CheckBoxesEnum;
import hw4.Enums.differentElementsPage.RadioButtonEnum;
import hw4.Enums.differentElementsPage.SelectEnum;
import org.openqa.selenium.support.FindBy;

public class DifferentElementPage {
    private int checkBoxesAmount = 4;
    private int radioButtonsAmount = 4;
    private int buttonsAmount = 2;

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

    public void open() {
        Selenide.open(ServiceTabOptions.DIFFERENTELEMENTS.url);
    }

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

    public void selectCheckboxElement(int index) {
        checkBoxesBoard.get(index).click();
    }

    public void verifyCheckBoxLogRow(int index, boolean action) {
        log.get(0).shouldHave(Condition.text(CheckBoxesEnum.getTextValue(index) + ": condition changed to " + String.valueOf(action)));
    }

    public void selectRadioElement(int index) {
        radioButtonsBoard.get(index).click();
    }


    public void verifyRadioButtonLogRow(int index) {
        log.get(0).shouldHave(Condition.text("metal: value changed to " + RadioButtonEnum.getTextValue(index)));
    }


    public void selectDropDownElement(int index) {
        dropDownEntryMode.click();
        dropDownElements.get(index).click();
    }

    public void verifyDropDownElementLogRow(int index) {
        log.get(0).shouldHave(Condition.text("Colors: value changed to " + SelectEnum.getTextValue(index)));
    }
}