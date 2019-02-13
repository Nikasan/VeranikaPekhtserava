package hw3;

import hw3.enums.BenefitsTextList;
import hw3.enums.HomePageInfo;
import hw3.enums.NavigationBarItems;
import hw3.enums.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static hw3.enums.HomePageInfo.HOME_PAGE_URL;
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
    private WebElement iconCustom;

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
        driver.get(HOME_PAGE_URL.value);
    }

    public void checkTitle(HomePageInfo title) {
        assertEquals(driver.getTitle(), title.value);
    }

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLogged(User user) {
        assertEquals(userName.getText(), user.name);
    }

    public void checkFourthImages() {
        assertTrue(iconBase.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconCustom.isDisplayed());
    }

    public void checkItemsTexts(NavigationBarItems[] itemsText) {
        assertTrue(items.isDisplayed());
        for (NavigationBarItems item : itemsText) {
            assertTrue(items.getText().contains(item.item));
        }
    }

public void checkFourTextsUnderBenefitImages(BenefitsTextList[] expected) {
    assertEquals(benefitText.size(), 4);
    for (int i = 0; i < expected.length; i++) {
        assertEquals(benefitText.get(i).getText(), expected[i].toString());
    }
}

    public void checkTextOnMainHeaders(HomePageInfo titleOnMainHeaders, HomePageInfo textOnMainHeaders) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(titleOnMainHeaders.value, mainTitle.getText());
        assertTrue(jdiText.isDisplayed());
        assertEquals(textOnMainHeaders.value, jdiText.getText());
    }

    public void iframeIsDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkIframeLogo() {
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void checkTextOfSubHeader(HomePageInfo textOfTheSubHeader) {
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), textOfTheSubHeader.value);
    }

    public void checkJdiGit(HomePageInfo jdiGithubUrl) {
        assertEquals(blank.getAttribute("href"), jdiGithubUrl.value);
    }

    public void leftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void footerIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}