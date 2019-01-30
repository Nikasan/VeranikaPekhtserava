package hw2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/* TODO
    1. Class has name not as described in Java Code Convention
    2. Class located not in package as described in requirements
 */
public class ex1 extends SeleniumBase {

    private ChromeOptions options;

    @DataProvider(parallel = true)
    private Object[][] simpleDataProvider() {
        /* TODO
            1. Why you decide use int as first parameter?
            2. Is it required using string concatenation here?
         */
        return new Object[][] {
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @BeforeClass
    public void beforeClass() {
        // TODO What is the purpose of using ChromeOptions?
        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }


    @Test(dataProvider = "simpleDataProvider")
    /* TODO
        1. What is i means?
        2. What is s means?
     */
    public void simpleTest(int i, String s) {
        // TODO Do we have a better way create driver instance?
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        // TODO Is getting handle required here?
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //2
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3
        assertEquals(driver.findElements(By.xpath(".//div[@class = 'row clerafix benefits']/div")).get(i).getText(), s);

        // TODO do we have a better way close driver instance?
        driver.close();
    }
}
