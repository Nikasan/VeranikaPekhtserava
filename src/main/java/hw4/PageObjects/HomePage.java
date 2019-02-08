package hw4.PageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.HomePageInfo;
import hw4.Enums.ServiceTabOptions;
import hw4.Enums.User;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// TODO Please do not forget delete unused imports

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.Enums.HomePageInfo.HOME_PAGE_TITLE;
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
// TODO Extra empty line

    @FindBy(css = ".uui-side-bar")
    private SelenideElement leftSection;

    @FindBy(css = ".footer-bg")
    private SelenideElement footer;
// TODO Extra empty line

    @FindBy(css =".nav.navbar-nav > li > a")
    private ElementsCollection navBarItems;

    @FindBy(css = ".main-title")
    private SelenideElement headerText;

    @FindBy(css = "ul[class = 'dropdown-menu'] > li > a[href = 'different-elements.html']")
    private SelenideElement serviceDifferentElemetsPageLink;
    // TODO Is current comment required here?
    //  ul[class = 'dropdown-menu'] > a[href = 'different-elements.html']

    @FindBy(css = ".uui-header .nav li.dropdown")
    private SelenideElement serviceDropDownMenuHeader;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement serviceDropDownMenuLeft;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection serviceTabHeader;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection serviceTabLeftMenu;
// TODO Extra empty line
// TODO Extra empty line

    public void checkBrowserTitle() {
        assertEquals(title(), HOME_PAGE_TITLE.toString());
    }

    public void signIn(User user) {
// TODO Extra empty line
        loginIcon.click();
        userField.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }
// TODO name is not good name for the parameter
    public void checkUserIsLogged(User name){
        userName.shouldHave(Condition.exactText(name.name));
    }
// TODO Extra empty line
// TODO please format method properly
        public void checkNavBarServiceOptions() {
            serviceDropDownMenuHeader.click();
            checkElementsTexts(serviceTabHeader, ServiceTabOptions.getLinkNames());
    }

    private void checkElementsTexts(ElementsCollection elements, List<String> texts) {
        int textsCount = texts.size();
        elements.shouldHaveSize(textsCount);
        // TODO please try avoid using loop here
        for (int i = 0; i < textsCount; i++) {
            elements.get(i).shouldHave(Condition.exactText(texts.get(i)));
        }
    }

    public void checkSideBarServiceOptions() {
        serviceDropDownMenuLeft.click();
        checkElementsTexts(serviceTabLeftMenu, ServiceTabOptions.getLinkNames());
    }

    public void goToDifferentElementsPage(){
        serviceDropDownMenuHeader.click();
        serviceDifferentElemetsPageLink.click();

    }
    // TODO Is this commented code required?
//
//    public void check4imagesArePresented() {
//        for (SelenideElement image : imageElements) {
//            image.shouldBe(Condition.visible);
//        }
//    }
//
//    public void check4TextsUnderImages(List<String> textContent) {
//        checkElementsTexts(textsUndrImages, textContent);
//    }
//
//    public void checkMainHeaderTextIsEqualTo(String textValue) {
//        headerText.shouldHave(Condition.exactText(textValue));
//    }
//
//    public void checkSubheaderTextIsEqualTo(String textValue) {
//        subHeaderText.shouldHave(Condition.exactText(textValue));
//    }
//
//    public void checkJDIurlEqualsTo(String urlValue) {
//        jdiGitHubLink.shouldHave(Condition.exactText(urlValue));
//    }
//
//    public void checkLeftSectionIsDisplayed() {
//        leftSection.shouldBe(Condition.visible);
//    }
//
//    public void checkFooterIsDisplayed() {
//        footer.shouldBe(Condition.visible);
//    }
//

}
