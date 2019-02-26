package hw8;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw8.base.EpamSite;
import hw8.entities.MetalsColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw8.base.EpamSite.indexPageJdi;
import static hw8.base.EpamSite.metalsColorsPage;
import static hw8.entities.User.PETER;


public class JdiSimpleExample {
    MetalsColors parameters = new MetalsColors();

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(EpamSite.class);
    }

    @Test
    public void simpleJdiTest() {
        indexPageJdi.open();
        indexPageJdi.login(PETER);
        metalsColorsPage.open();
        metalsColorsPage.shouldBeOpened();

        metalsColorsPage.fillForm(parameters);
        metalsColorsPage.submitForm();
        metalsColorsPage.checkForm(parameters);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
