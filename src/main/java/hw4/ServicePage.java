package hw4;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.HomePageInfo;
import hw4.Enums.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.Enums.HomePageInfo.HOME_PAGE_TITLE;
import static org.testng.AssertJUnit.assertEquals;

public class ServicePage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;


    public ServicePage() {

    }


    public void openHomePage() {
        Selenide.open(HomePageInfo.HOME_PAGE_URL.toString());
    }

    public  void checkBrowserTitle(){
        assertEquals(getWebDriver().getTitle(), HOME_PAGE_TITLE.toString());
    }

    public void performLogin(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
//        $("[id='user-icon']").click();
//        $("[id='name']").sendKeys(user.login);
//        $("[id='password']").sendKeys(user.password);
//        $("[id='login-button']").click();
    }

    public void checkUserIsLogged(){
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

}

