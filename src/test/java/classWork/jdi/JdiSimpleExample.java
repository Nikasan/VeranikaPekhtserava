package classWork.jdi;


import base.jdi.JDISite;
import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.JDISite.indexPageJdi;
import static base.jdi.JDISite.metalsColorsPage;
import static base.jdi.entities.User.PETER;


public class JdiSimpleExample {
    @BeforeSuite
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(LogLevels.INFO);
        WebSettings.SEARCH_CONDITION = WebElement::isDisplayed;

        PageFactory.initElements(JDISite.class);
        ActionHelper.BEFORE_JDI_ACTION = jp -> {
        };
        ActionHelper.AFTER_JDI_ACTION = (jp, o) -> ActionHelper.AFTER_STEP_ACTION.execute(jp, o);

    }

    @Test
    public void simpleJdiTest() {
        indexPageJdi.open();
        indexPageJdi.login(PETER);
        metalsColorsPage.open();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
        WebSettings.KILL_BROWSER = "";

    }

}
