package hw3;

import hw3.Enums.HomePageInfo;
import hw3.Enums.NavigationBarItems;
import hw3.Enums.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import static hw3.Enums.BenefitsTextList.*;
import static hw3.Enums.HomePageInfo.HOME_PAGE_URL;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']")
    private WebElement items;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconСustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(css = "[class='benefit-txt']")
    private List<WebElement> benefitText;

    @FindBy(css = "[name='main-title']")
    private WebElement mainTitle;

    @FindBy(css = "[name='jdi-text']")
    private WebElement jdiText;

   @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[class='text-center']")
    private WebElement textCenter;

    @FindBy(css = "a[target='_blank']")
    private WebElement blank;

    @FindBy(css = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")
    private WebElement leftSection;

    @FindBy(css = "[class='footer-bg']")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void open() {
        driver.get(HOME_PAGE_URL.toString());
    }

    public  void checkTitle(HomePageInfo title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLoggined(User user) {
        assertEquals(userName.getText(), user.name);
    }

    public void chekFourthImages() {
        assertTrue(iconBase.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconСustom.isDisplayed());
    }

    public void chekItemsTexts(NavigationBarItems[] itemsText) {
        assertTrue(items.isDisplayed());
        for (NavigationBarItems item : itemsText) {
            assertTrue(items.getText().contains(item.toString()));
        }
    }

    public void chekTextUnderIcons() {
        Assert.assertEquals(benefitText.size(), 4);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(),FIRST_ICON_TEXT.toString());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(),SECOND_ICON_TEXT.toString());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(),THIRD_ICON_TEXT.toString());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(),FOURTH_ICON_TEXT.toString());
        }


    public void chekTextOnMainHeaders(HomePageInfo titleOnMainHeaders, HomePageInfo textOnMainHeaders) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(titleOnMainHeaders.toString(), mainTitle.getText());
        assertTrue(jdiText.isDisplayed());
        assertEquals(textOnMainHeaders.toString(), jdiText.getText());
    }

    public void IframeIsDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkIframeLogo() {
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void chekTextOfSubHeader(HomePageInfo textOfTheSubHeader) {
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), textOfTheSubHeader.toString());
    }

    public void chekJdiGit(HomePageInfo jdiGithubUrl) {
        assertEquals(blank.getAttribute("href"), jdiGithubUrl.toString());
    }

    public void LeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void FooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}