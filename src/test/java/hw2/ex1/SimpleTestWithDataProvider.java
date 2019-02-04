package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider extends SeleniumBase {

    private WebDriver driver;

    @DataProvider(parallel = true)
    private Object[][] benefitItemText() {
        /*
            1. Why you decide use int as first parameter?
            -I need this index to determine concrete WebElement from driver.findElements(By.cssSelector(".benefit-txt"))
            2. Is it required using string concatenation here?
           -It is not necessary, but I used it to improve code readability
           Without concatenation it looks like: "To include good practices\nand ideas from successful\nEPAM project"
         */

        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"},
        };
    }

    // TODO I suggest do not use @BeforeTest setting for driver initialization
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    // TODO I suggest do not use @AfterTest setting for driver closing
    @AfterTest
    public void afterMethod() {
        driver.close();
    }

    @Test(dataProvider = "benefitItemText")
        /* TODO
            1. What is i means?
            2. What is s means?
     */
    public void checkItemsTexts(int i, String s) {

        //1 Open site
        // TODO It could be moved to @BeforeMethod
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2
        List<WebElement> benefitIconTxt = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(benefitIconTxt.size(), 4);
        assertEquals(benefitIconTxt.get(i).getText(), s);
    }
}
