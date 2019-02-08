package hw4;

import com.codeborne.selenide.Selenide;
import hw4.Enums.HomePageInfo;
import hw4.PageObjects.DatesPage;
import hw4.PageObjects.HomePage;
import hw4.base.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static hw4.Enums.User.USER;

public class SelenideDatesPageTest extends SelenideBase {
    private HomePage servicePage;
    private DatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(HomePageInfo.HOME_PAGE_URL.toString());
        servicePage = page(HomePage.class);
        datesPage = page(DatesPage.class);

        //2.Assert Browser title
        servicePage.checkBrowserTitle();
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void simpleTest() {
        //3.Perform login
        servicePage.signIn(USER);

        //4.Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged(USER);

        //5.Open through the header menu Service -> Different Elements Page
        datesPage.open();

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.moveSliders(0,100);

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog("0","100");

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position and assert the log row
         datesPage.moveSliders(0,0);

         //9. Assert log row
        datesPage.checkLog("0","0");

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most right position and assert the log row
        datesPage.moveSliders(100, 100);

        //11. Assert log row
        datesPage.checkLog("100","100");

        //12.Using drag-and-drop set Range sliders.
        datesPage.moveSliders(30, 70);

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog("30","70");
    }
}