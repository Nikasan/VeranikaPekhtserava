package hw2.ex1;

import base.SeleniumBase;
import hw2.DriverFactory.DriverClass;
import hw2.DriverFactory.DriverFactory;
import hw2.DriverFactory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider extends SeleniumBase {

    @DataProvider(parallel = true)
    private Object[][] benefitItemText() {
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

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {

        DriverClass driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);

        DriverManager.getDriver().getRemoteWebDriver().manage().window().maximize();
        DriverManager.getDriver().getRemoteWebDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        //1.Open test site by URL
        DriverManager.getDriver().getRemoteWebDriver().navigate().to("http://epam.github.io/JDI/index.html");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        DriverManager.getDriver().getRemoteWebDriver().close();
    }

    @Test(dataProvider = "benefitItemText")
    public void checkItemsTexts(int i, String s) {
        //2 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconTxt = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector(".benefit-txt"));
        assertEquals(benefitIconTxt.size(), 4);
        assertEquals(benefitIconTxt.get(i).getText(), s);
    }
}
