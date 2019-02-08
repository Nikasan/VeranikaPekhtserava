package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.ServiceTabOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = "a.ui-slider-handle:nth-child(1)")
    private SelenideElement sliderLeft;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private SelenideElement sliderRight;

    @FindBy(css = "div#mCSB_2_container li")
    public ElementsCollection log;

    @FindBy(css = ".uui-slider")
    public SelenideElement track;
    Actions actions = new Actions(getWebDriver());

    public void open() {
        Selenide.open(ServiceTabOptions.DATES.url);
    }

    public void moveSliders(int xFrom, int xTo) {
        actions.clickAndHold(sliderLeft).moveToElement(track,  ((track.getSize().width) * (xFrom)/100 ), 0).release().build().perform();
        actions.clickAndHold(sliderRight).moveToElement(track, ((track.getSize().width) * (xTo)/100 ), 0).release().build().perform();
    }

    public void checkLog(String logFrom, String logTo) {
        log.get(1).should(Condition.text(logFrom + " link clicked"));
        log.get(0).should(Condition.text(logTo + " link clicked"));
    }
}