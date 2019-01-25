package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestHomePageItems {


    private WebDriver driver;
    private ChromeOptions options;

    @BeforeClass
    public void beforeClass() {

        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @BeforeMethod
    public void beforeMethod() {

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.close();
//    }

    //
    @Test
    public void TestHomePageItems() {

        driver.navigate().to("http://epam.github.io/JDI/index.html");
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        assertEquals(driver.findElement(By.xpath(".//div[@class = 'profile-photo']/span[@ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title

        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(itemsName.size(), 4);

        List<String> itemNamesExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> itemsNamesActual = new LinkedList<String>();
        for (WebElement element : itemsName) {
            itemsNamesActual.add(element.getText());
        }
        assertEquals(itemsNamesActual, itemNamesExpected);

        // System.out.println(itemsName.get(0).getText());


    }
}
