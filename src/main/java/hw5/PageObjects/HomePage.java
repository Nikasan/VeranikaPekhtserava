package hw5.PageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw5.Enums.ServiceTabOptions;
import hw5.Enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.title;
import static hw4.enums.HomePageInfo.HOME_PAGE_TITLE;
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


    @FindBy(css = ".uui-side-bar")
    private SelenideElement leftSection;

    @FindBy(css = ".footer-bg")
    private SelenideElement footer;


    @FindBy(css = ".nav.navbar-nav > li > a")
    private ElementsCollection navBarItems;

    @FindBy(css = ".main-title")
    private SelenideElement headerText;

    @FindBy(css = "ul[class = 'dropdown-menu'] > li > a[href = 'different-elements.html']")
    private SelenideElement serviceDifferentElemetsPageLink;
    //  ul[class = 'dropdown-menu'] > a[href = 'different-elements.html']

    @FindBy(css = ".uui-header .nav li.dropdown")
    private SelenideElement serviceDropDownMenuHeader;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement serviceDropDownMenuLeft;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection serviceTabHeader;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection serviceTabLeftMenu;


    @Step("Check browser title.")
    public void checkBrowserTitle() {
        assertEquals(title(), HOME_PAGE_TITLE.toString());
    }

    @Step("Perform login.")
    public void signIn(User user) {

        loginIcon.click();
        userField.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Check that user logged and has proper name.")
    public void checkUserIsLogged(User name) {
        userName.shouldHave(Condition.exactText(name.name));
    }

@Step("Click on 'Service' subcategory in the header and check that drop down contains options:'Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements'")
    public void checkNavBarServiceOptions() {
        serviceDropDownMenuHeader.click();
        checkElementsTexts(serviceTabHeader, ServiceTabOptions.getLinkNames());
    }

    private void checkElementsTexts(ElementsCollection elements, List<String> texts) {
        int textsCount = texts.size();
        elements.shouldHaveSize(textsCount);
        for (int i = 0; i < textsCount; i++) {
            elements.get(i).shouldHave(Condition.exactText(texts.get(i)));
        }
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options:'Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements'")
    public void checkSideBarServiceOptions() {
        serviceDropDownMenuLeft.click();
        checkElementsTexts(serviceTabLeftMenu, ServiceTabOptions.getLinkNames());
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void goToDifferentElementsPage() {
        serviceDropDownMenuHeader.click();
        serviceDifferentElemetsPageLink.click();
    }
}
