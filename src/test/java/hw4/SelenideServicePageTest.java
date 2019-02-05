package hw4;

import com.codeborne.selenide.Selenide;
import hw4.Enums.HomePageInfo;
import hw4.Enums.User;
import hw4.base.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.Enums.HomePageInfo.HOME_PAGE_TITLE;
import static hw4.Enums.User.USER;
import static org.testng.Assert.assertEquals;

public class SelenideServicePageTest extends SelenideBase {
    private ServicePage servicePage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(HomePageInfo.HOME_PAGE_URL.toString());
        servicePage = page(ServicePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void simpleTest() {

        //2 Assert Browser title
        servicePage.checkBrowserTitle();

        //3 Perform login
        servicePage.performLogin(USER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged();


    }
}
