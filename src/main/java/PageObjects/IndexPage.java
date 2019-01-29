package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    // @FindBy(className="user")
    private WebElement loginItem;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;

    private static WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
   }

    public void login(String name, String password) {
        loginItem = driver.findElement(By.name("user-icon"));
        userField = driver.findElement(By.name("user"));
        passwordField = driver.findElement(By.name("password"));
       submitButton = driver.findElement(By.name("login-button"));
       loginItem.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open() {
        driver.get("http://epam.github.io/JDI/index.html");
    }
}

