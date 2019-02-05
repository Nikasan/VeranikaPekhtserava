package hw4;
import hw4.Enums.HomePageInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatesPage {
    @FindBy(css = "[id='user-icon']")
    private List<WebElement> loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    private WebDriver driver;

    public DatesPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String name, String password) {
        loginIcon.get(1).click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open() {
        driver.get(HomePageInfo.HOME_PAGE_URL.toString());
    }
}

