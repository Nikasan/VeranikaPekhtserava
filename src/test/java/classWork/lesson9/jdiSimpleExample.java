package classWork.lesson9;

import base.jdi.lesson1.entities.User;
import base.jdi.lesson1.JDISite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class jdiSimpleExample {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuit(){
        PageFactory.initElements(JDISite.class);
        //logger.info("Run Tests");
    }
    @Test
    public void simpleJdiTest(){
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(User.PETER);
    }

    @AfterSuite
    public void afterSuit(){
        WebDriverFactory.close();
    }
}
