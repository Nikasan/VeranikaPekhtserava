package hw6.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw6.enums.BenefitsTextList;
import hw6.enums.HomePageInfo;
import hw6.enums.ServiceTabOptions;
import hw6.enums.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement password;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

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

    @FindBy(css = "div.benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(css = "[class='benefit-txt']")
    private ElementsCollection benefitText;

    @FindBy(css = "[name='main-title']")
    private WebElement mainTitle;

    @FindBy(css = "[name='jdi-text']")
    private WebElement jdiText;

    @FindBy(css = ".uui-side-bar")
    private SelenideElement leftSection;

    @FindBy(css = ".nav.navbar-nav > li > a")
    private ElementsCollection navBarItems;

    @FindBy(css = ".main-title")
    private SelenideElement headerText;

    @FindBy(css = ".uui-header .nav li.dropdown")
    private SelenideElement serviceDropDownMenuHeader;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement serviceDropDownMenuLeft;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection headerServiceOptions;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection serviceTabLeftMenu;

    public void checkBrowserTitle(HomePageInfo title) {
        assertEquals(title(), title.value);
    }

    public void signIn(User user) {

        loginIcon.click();
        userField.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLogged(User user) {
      //  userName.shouldHave(Condition.exactText(user.name));
        userName.shouldHave(text(user.name));
    }

    public void checkFourthImages() {
        assertTrue(iconBase.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconCustom.isDisplayed());
    }

    public void checkBenefitTexts(BenefitsTextList[] expected) {
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

    public void openSrviceDropdownFromHeader() {
        serviceDropDownMenuHeader.click();
    }

    public void checkServiceOptionsFromHeader(List<ServiceTabOptions> dropdownElements) {
        for (int i = 0; i < dropdownElements.size(); i++) {
            headerServiceOptions.get(i).exists();
            headerServiceOptions.get(i).shouldHave(text(dropdownElements.get(i).toString()));
        }
    }

    public void openServiceMenuInLeftSection() {
        serviceDropDownMenuLeft.click();
    }

    public void checkSideBarServiceOptions(List<ServiceTabOptions> dropdownElements) {
        for (int i = 0; i < dropdownElements.size(); i++) {
            serviceTabLeftMenu.get(i).exists();
            serviceTabLeftMenu.get(i).shouldHave(text(dropdownElements.get(i).toString()));
        }
    }

    public void openServiceOptions(ServiceTabOptions option) {
        open(option.url);
    }
}
