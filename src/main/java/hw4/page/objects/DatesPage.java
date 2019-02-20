package hw4.page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    Actions actions = new Actions(getWebDriver());

    @FindBy(css = "div#mCSB_2_container li")
    private ElementsCollection log;

    @FindBy(css = ".uui-slider")
    private SelenideElement track;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    public void moveSliderCheckLog(int slider, int direction) {
        actions.clickAndHold(sliders.get(slider)).moveToElement(track, ((track.getSize().width) * (direction) / 100), 0).release().build().perform();
        log.get(0).should(Condition.text(direction + " link clicked"));
    }
}