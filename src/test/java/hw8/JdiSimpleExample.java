package hw8;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw8.base.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw8.base.JDISite.indexPageJdi;
import static hw8.base.JDISite.metalsColorsPage;
import static hw8.entities.User.PETER;


public class JdiSimpleExample {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void simpleJdiTest() {
        indexPageJdi.open();
        indexPageJdi.login(PETER);
        metalsColorsPage.open();
        metalsColorsPage.shouldBeOpened();
        metalsColorsPage.culculateSummarySectionCheckLog(3,8);

    }

    @AfterSuite
    public void afterSuite() {

       WebDriverFactory.close();
    }

}
