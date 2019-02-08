package hw4;

import com.codeborne.selenide.Selenide;
import hw4.Enums.HomePageInfo;
import hw4.Enums.differentElementsPage.CheckBoxesEnum;
import hw4.Enums.differentElementsPage.RadioButtonEnum;
import hw4.Enums.differentElementsPage.SelectEnum;
import hw4.PageObjects.DifferentElementPage;
import hw4.PageObjects.HomePage;
import hw4.base.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static hw4.Enums.User.USER;

public class SelenideServicePageTest extends SelenideBase {
    private HomePage servicePage;
    private DifferentElementPage dePage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(HomePageInfo.HOME_PAGE_URL.toString());
        servicePage = page(HomePage.class);
        dePage = page(DifferentElementPage.class);

        //2 Assert Browser title
        servicePage.checkBrowserTitle();
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

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

        // 7 Open through the header menu Service -> Different Elements Page
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
        dePage.selectCheckboxElement(CheckBoxesEnum.WATER.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WATER.index,true);

        dePage.selectCheckboxElement(CheckBoxesEnum.EARTH.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.EARTH.index, true);

        dePage.selectCheckboxElement(CheckBoxesEnum.WIND.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WIND.index, true);

        dePage.selectCheckboxElement(CheckBoxesEnum.FIRE.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.FIRE.index, true);

        //13 Select radio SELEN
        dePage.selectRadioElement(RadioButtonEnum.SELEN.index);

        //14 Assert that for radiobutton SELEN there is a log row and value is corresponded to the status of radiobutton. 
        dePage.verifyRadioButtonLogRow(RadioButtonEnum.SELEN.index);

        //15 Select YELLOW in dropdown
        dePage.selectDropDownElement(SelectEnum.YELLOW.index);

        //16 Assert that for dropdown YELLOW there is a log row and value is corresponded to the selected value. 
        dePage.verifyDropDownElementLogRow(SelectEnum.YELLOW.index);

        //17-18  Unselect and assert checkboxes + Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        dePage.selectCheckboxElement(CheckBoxesEnum.WATER.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WATER.index, false);

        dePage.selectCheckboxElement(CheckBoxesEnum.WIND.index);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WIND.index, false);
    }
}
