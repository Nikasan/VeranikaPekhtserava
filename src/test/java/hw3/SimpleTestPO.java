package hw3;

import base.SeleniumBase;
import hw3.enums.BenefitsTextList;
import hw3.enums.NavigationBarItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static hw3.enums.HomePageInfo.*;
import static hw3.enums.User.USER;

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
    public void SimpleTestHomePage() {
        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(USER);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkUserIsLogged(USER);

        //5 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkItemsTexts(NavigationBarItems.values());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkFourthImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkFourTextsUnderBenefitImages(BenefitsTextList.values());

        //9 Assert a text of the main headers
        homePage.checkTextOnMainHeaders(MAIN_HEADER_TITLE, MAIN_HEADER_TEXT);

        //10 Assert that there is the iframe in the center of page
        homePage.iframeIsDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.checkIframeLogo();

        //12 Switch to original window back
        homePage.switchToDefaultContent();

        //13 Assert a text of the sub header
        homePage.checkTextOfSubHeader(SUB_HEADER_TEXT);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiGit(SUB_HEADER_URL);

        //15 Assert that there is Left Section
        homePage.leftSectionIsDisplayed();

        //16 Assert that there is Footer
        homePage.footerIsDisplayed();
    }
}