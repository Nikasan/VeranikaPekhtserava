package hw5;

import hw5.Listener.SimpleScreenshotTestListener;
import hw5.base.SelenideBase;
import hw5.page_objects.DifferentElementPage;
import hw5.page_objects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static hw5.enums.HomePageInfo.HOME_PAGE_URL;
import static hw5.enums.User.USER;
import static hw5.enums.different_elements_page.CheckBoxes.*;
import static hw5.enums.different_elements_page.Colors.YELLOW;
import static hw5.enums.different_elements_page.RadioButtons.SELEN;

@Listeners(SimpleScreenshotTestListener.class)
public class SelenideServicePageTest extends SelenideBase {
    private HomePage servicePage;
    private DifferentElementPage dePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        //1 Open test site by URL
        open(HOME_PAGE_URL.value);
        servicePage = page(HomePage.class);
        dePage = page(DifferentElementPage.class);// I init page here because I can check right page before test methods. In parallel run it can save time. And you suggest do it before.

        //2 Assert Browser title
        servicePage.checkBrowserTitle();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        close();
    }

    @Story(value = "HW5")
    @Feature(value = "Date page test")
    @Test
    public void simpleTest() {
        //3 Perform login
        servicePage.signIn(USER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged(USER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkNavBarServiceOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.checkSideBarServiceOptions();

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.goToDifferentElementsPage();

        //8 Check interface on Different elements page, it contains all needed elements
        dePage.checkNumberOfButtonsElements();
        dePage.checkNumberOfCheckBoxElements();
        dePage.checkDropDownMenuIsPresent();
        dePage.checkNumberOfRadioButtonElements();

        //9 Assert that there is Right Section
        dePage.checkFixPaneIsVisible();

        //10 Assert that there is Left Section
        dePage.checkNavBarIsVisible();

        //11-12 Select checkboxes and  Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox. 
        dePage.selectCheckboxElement(0); //I use index for click to checkbox from collection of elements
        dePage.verifyCheckBoxLogRow(WATER, true);

        dePage.selectCheckboxElement(1);
        dePage.verifyCheckBoxLogRow(EARTH, true);

        dePage.selectCheckboxElement(2);
        dePage.verifyCheckBoxLogRow(WIND, true);

        dePage.selectCheckboxElement(3);
        dePage.verifyCheckBoxLogRow(FIRE, true);

        //13 Select radio SELEN
        dePage.selectRadioElement(3);

        //14 Assert that for radiobutton SELEN there is a log row and value is corresponded to the status of radiobutton. 
        dePage.verifyRadioButtonLogRow(SELEN);

        //15 Select YELLOW in dropdown
        dePage.selectDropDownElement(YELLOW);

        //16 Assert that for dropdown YELLOW there is a log row and value is corresponded to the selected value. 
        dePage.verifyDropDownElementLogRow(YELLOW);

        //17-18  Unselect and assert checkboxes + Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        dePage.selectCheckboxElement(0);
        dePage.verifyCheckBoxLogRow(WATER, false);

        dePage.selectCheckboxElement(1);
        dePage.verifyCheckBoxLogRow(EARTH, false);

        dePage.selectCheckboxElement(2);
        dePage.verifyCheckBoxLogRow(WIND, false);

        dePage.selectCheckboxElement(3);
        dePage.verifyCheckBoxLogRow(FIRE, false);
    }
}