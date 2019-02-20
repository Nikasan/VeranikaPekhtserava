package hw4;

import hw4.page.objects.DifferentElementPage;
import hw4.page.objects.HomePage;
import hw4.base.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static hw4.enums.HomePageInfo.HOME_PAGE_URL;
import static hw4.enums.ServiceTabOptions.DIFFERENTELEMENTS;
import static hw4.enums.User.USER;
import static hw4.enums.different_elements_page.CheckBoxes.*;
import static hw4.enums.different_elements_page.RadioButtons.SELEN;
import static hw4.enums.different_elements_page.Colors.YELLOW;

public class SelenideServicePageTest extends SelenideBase {

    private HomePage homePage;
    private DifferentElementPage differentElementPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(HOME_PAGE_URL.value);
        homePage = page(HomePage.class);
        differentElementPage = page(DifferentElementPage.class);

        //2 Assert Browser title
        homePage.checkBrowserTitle();
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void simpleTest() {
        //3 Perform login
        homePage.signIn(USER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserIsLogged(USER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkNavBarServiceOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkSideBarServiceOptions();

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openServiceOptions(DIFFERENTELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementPage.checkNumberOfButtonsElements();
        differentElementPage.checkNumberOfCheckBoxElements();
        differentElementPage.checkDropDownMenuIsPresent();
        differentElementPage.checkNumberOfRadioButtonElements();

        //9 Assert that there is Right Section
        differentElementPage.checkFixPaneIsVisible();

        //10 Assert that there is Left Section
        differentElementPage.checkNavBarIsVisible();

        //11-12 Select checkboxes and  Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox. 
        differentElementPage.selectCheckboxElement(WATER);
        differentElementPage.verifyCheckBoxLogRow(WATER, true);

        differentElementPage.selectCheckboxElement(EARTH);
        differentElementPage.verifyCheckBoxLogRow(EARTH, true);

        differentElementPage.selectCheckboxElement(WIND);
        differentElementPage.verifyCheckBoxLogRow(WIND, true);

        differentElementPage.selectCheckboxElement(FIRE);
        differentElementPage.verifyCheckBoxLogRow(FIRE, true);

        //13 Select radio SELEN
        differentElementPage.selectRadioElement(SELEN);

        //14 Assert that for radiobutton SELEN there is a log row and value is corresponded to the status of radiobutton. 
        differentElementPage.verifyRadioButtonLogRow(SELEN);

        //15 Select YELLOW in dropdown
        differentElementPage.selectDropDownElement(YELLOW);

        //16 Assert that for dropdown YELLOW there is a log row and value is corresponded to the selected value. 
        differentElementPage.verifyDropDownElementLogRow(YELLOW);

        //17-18  Unselect and assert checkboxes + Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementPage.selectCheckboxElement(WATER);
        differentElementPage.verifyCheckBoxLogRow(WATER, false);

        differentElementPage.selectCheckboxElement(EARTH);
        differentElementPage.verifyCheckBoxLogRow(EARTH, false);

        differentElementPage.selectCheckboxElement(WIND);
        differentElementPage.verifyCheckBoxLogRow(WIND, false);

        differentElementPage.selectCheckboxElement(FIRE);
        differentElementPage.verifyCheckBoxLogRow(FIRE, false);
    }
}