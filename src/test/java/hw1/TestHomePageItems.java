package hw1;

import base.SeleniumBase;
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

public class TestHomePageItems extends SeleniumBase {


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

        //1.Open test site by URL

        driver.navigate().to("http://epam.github.io/JDI/index.html");

        //2 Assert Browser title

        assertEquals(driver.getTitle(), "Home Page");

        //3.Perform login

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined

        assertEquals(driver.findElement(By.xpath(".//div[@class = 'profile-photo']/span[@ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title

        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(itemsName.size(), 4);
//!!! missed check if elements are displayed
        List<String> itemNamesExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> itemsNamesActual = new LinkedList<String>();
        for (WebElement element : itemsName) {
            itemsNamesActual.add(element.getText());
        }
        //we don't use asserts for list because if it fails log wouldn't show what text is differ from expected, use text of elements for assert
        assertEquals(itemsNamesActual, itemNamesExpected);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        //!!!xpath too long, you can make it shorter, even use CSS
        List<WebElement> imageElements = driver.findElements(By.xpath("//div[@class='benefit' and 1]/div[@class='benefit-icon' and 1]"));
        assertEquals(imageElements.size(), 4);

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
        //!!!xpath too long, you can make it shorter, even use CSS
        List<WebElement> benefirIconTxt = driver.findElements(By.xpath("//div[@class='benefit' and 1]/span[@class='benefit-txt' and 1]"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefirIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        //we don't use asserts for list because if it fails log wouldn't show what text is differ from expected, use text of elements for assert
        assertEquals(underIconsTextsActual, underIconsTextsEXpected);

        //9 Assert a text of the main headers

        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "LOREM IPSUM DOLOR SIT AMET, ";
        //not CONTAINS but EQUALS
        assertTrue(driver.findElement(By.xpath("//h3[@class='main-title text-center']")).getText().contains(h3));
        assertTrue(driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText().contains(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe

//why you have 2 elements for iframe? You shoulduse one common element
        WebElement iframeSwitch = driver.findElement(By.id("iframe"));
        driver.switchTo().frame(iframeSwitch);
        //don't use System.out.println
        System.out.println("Switched");
        //assertTrue(driver.findElement(By.xpath("html/body/header/div/nav/div[2]")).isDisplayed());
        //assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back

        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        //use camelCase for variables names
        //avoid to use indexes in selectors
        WebElement jdi_github_link = driver.findElement(By.cssSelector("h3.text-center:nth-child(3) > a:nth-child(1)"));
        assertEquals(jdi_github_link.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL

        assertEquals(jdi_github_link.getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        //avoid to use indexes in selectors
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar > div:nth-child(1)")).isDisplayed());

        //16.Assert that there is Footer
        //avoid to use indexes in selectors
        assertTrue(driver.findElement(By.cssSelector("body > footer:nth-child(3)")).isDisplayed());

    }
}
