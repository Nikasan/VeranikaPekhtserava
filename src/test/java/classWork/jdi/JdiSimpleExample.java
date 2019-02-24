package classWork.jdi;


import base.jdi.JDISite;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.JDISite.indexPageJdi;
import static base.jdi.entities.User.PETER;


public class JdiSimpleExample {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void simpleJdiTest() {
        indexPageJdi.open();
        indexPageJdi.login(PETER);
        //indexPageJdi.login("epam", "1234");
    }

    @AfterSuite
    public void afterSuite() {
//        WebDriverFactory.close();
//        driver.close();
    }

}
