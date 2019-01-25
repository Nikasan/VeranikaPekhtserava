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
import static org.testng.Assert.assertTrue;

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

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    //
    @Test
    public void TestHomePageItemsHW1() {

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

        //7 Assert that there are 4 images on the Index Page and they are displayed
        //List<WebElement> imgIndexPage = driver.findElements(By.tagName("img")); Спросить у преподавателя


       List<WebElement> imageElements = driver.findElements(By.xpath("//div[@class='benefit' and 1]/div[@class='benefit-icon' and 1]"));
        assertEquals(imageElements.size(),4);

       for (int i = 0; i < imageElements.size(); i++) {
            assertTrue(imageElements.get(i).isDisplayed());
        }


       //8 Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<String> underIconsTextsEXpected = Arrays.asList(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> benefirIconTxt = driver.findElements(By.xpath("//div[@class='benefit' and 1]/span[@class='benefit-txt' and 1]"));
        List<String> underIconsTextsActual = new LinkedList<String>() ;
        for (WebElement element: benefirIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual,underIconsTextsEXpected);


        //9 Assert a text of the main headers
        //h3[@class='main-title text-center']
        //p[@class='main-txt text-center']
        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "LOREM IPSUM DOLOR SIT AMET, ";
        assertTrue(driver.findElement(By.xpath("//h3[@class='main-title text-center']")).getText().contains(h3));
        assertTrue(driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText().contains(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

    }
}
