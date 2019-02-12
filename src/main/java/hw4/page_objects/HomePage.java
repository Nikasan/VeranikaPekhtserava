package hw4.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.ServiceTabOptions;
import hw4.enums.User;
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

    @FindBy(css = ".nav.navbar-nav > li > a")
    private ElementsCollection navBarItems;

    @FindBy(css = ".main-title")
    private SelenideElement headerText;

    @FindBy(css = "ul[class = 'dropdown-menu'] > li > a[href = 'different-elements.html']")
    private SelenideElement serviceDifferentElemetsPageLink;

    @FindBy(css = ".uui-header .nav li.dropdown")
    private SelenideElement serviceDropDownMenuHeader;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement serviceDropDownMenuLeft;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection serviceTabHeader;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection serviceTabLeftMenu;

    public void checkBrowserTitle() {
        assertEquals(title(), HOME_PAGE_TITLE.value);
    }

    public void signIn(User user) {

        loginIcon.click();
        userField.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLogged(User user) {
        userName.shouldHave(Condition.exactText(user.name));
    }

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

    public void checkSideBarServiceOptions() {
        serviceDropDownMenuLeft.click();
        checkElementsTexts(serviceTabLeftMenu, ServiceTabOptions.getLinkNames());
    }

    // TODO Is it possible parametrized this method?
    public void goToDifferentElementsPage() {
        serviceDropDownMenuHeader.click();
        serviceDifferentElemetsPageLink.click();
    }
}
