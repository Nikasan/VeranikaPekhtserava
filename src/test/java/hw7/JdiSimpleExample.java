package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw7.base.EpamSite;
import hw7.entities.MetalsColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static hw7.base.EpamSite.indexPageJdi;
import static hw7.base.EpamSite.metalsColorsPage;

public class JdiSimpleExample {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(EpamSite.class);
    }

    @Test
    public void simpleJdiTest() {

        indexPageJdi.open();
        indexPageJdi.login();
        metalsColorsPage.open();
        metalsColorsPage.shouldBeOpened();

        MetalsColors parameters = new MetalsColors();
        metalsColorsPage.fillForm(parameters);
        metalsColorsPage.submitForm();
        metalsColorsPage.checkForm(parameters);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
