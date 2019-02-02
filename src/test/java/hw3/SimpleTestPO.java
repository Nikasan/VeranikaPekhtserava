package hw3;

import hw3.Enums.BenefitsTextList;
import hw3.Enums.User;
import base.SeleniumBase;
import hw3.Enums.NavigationBarItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static hw3.Enums.HomePageInfo.*;

public class SimpleTestPO extends SeleniumBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void tests() {
        //1 Open test site by URL
        homePage.open(HOME_PAGE_URL);

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(User.USER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserIsLoggined(User.USER);

        //5 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.chekItemsTexts(NavigationBarItems.values());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.chekFourthImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.chekTextUnderIcons(BenefitsTextList.values());

        //9 Assert a text of the main headers
        homePage.chekTextOnMainHeaders(MAIN_HEADER_TITLE, MAIN_HEADER_TEXT);

        //10 Assert that there is the iframe in the center of page
        homePage.IframeIsDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.chekIframeLogo();

        //12 Switch to original window back
        homePage.switchToDefaultContent();

        //13 Assert a text of the sub header
        homePage.chekTextOfSubHeader(SUB_HEADER_TEXT);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.chekJdiGit(SUB_HEADER_URL);

        //15 Assert that there is Left Section
        homePage.LeftSectionIsDisplayed();

        //16 Assert that there is Footer
        homePage.FooterIsDisplayed();
    }
}