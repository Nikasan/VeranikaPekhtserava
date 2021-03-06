package hw5;

import hw5.listener.SimpleScreenshotTestListener;
import hw5.base.SelenideBase;
import hw5.page.objects.DatesPage;
import hw5.page.objects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static hw5.enums.HomePageInfo.HOME_PAGE_URL;
import static hw5.enums.User.USER;

@Listeners(SimpleScreenshotTestListener.class)
public class SelenideDatesPageTest extends SelenideBase {
    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        //1 Open test site by URL
        open(HOME_PAGE_URL.value);
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);

        //2.Assert Browser title
        homePage.checkBrowserTitle();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        close();
    }

    @Story(value = "HW5")
    @Feature(value = "Date page test")
    @Test
    public void simpleTest() {
        //3.Perform login
        homePage.signIn(USER);

        //4.Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserIsLogged(USER);

        //5.Open through the header menu Service -> Dates Page
        homePage.openServiceOptions(1);

        //6-13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        List<Integer> directionFrom = Arrays.asList(0, 100, 30);
        List<Integer> directionTo = Arrays.asList(0, 100, 70);
        for (int i = 0; i < 3; i++) {
            Integer left = directionFrom.get(i);
            Integer right = directionTo.get(i);
            datesPage.moveSliderCheckLog(0, left);
            datesPage.moveSliderCheckLog(1, right);
        }
    }
}