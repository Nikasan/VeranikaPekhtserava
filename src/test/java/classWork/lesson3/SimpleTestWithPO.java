package classWork.lesson3;

import PageObjects.IndexPage;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTestWithPO extends SeleniumBase {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeMethod
    public void initTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = new IndexPage(driver);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void SimpleTest() {

    }

}