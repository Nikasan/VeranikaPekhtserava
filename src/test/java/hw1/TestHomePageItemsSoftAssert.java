package hw1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestHomePageItemsSoftAssert extends SeleniumBase {

    SoftAssert softAssert = new SoftAssert();

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

        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3.Perform login

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined

        softAssert.assertEquals(driver.findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title

        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = driver.findElements(By.cssSelector("ul.uui-navigation:nth-child(3) > li"));

        softAssert.assertEquals(itemsName.size(), 4);

        softAssert.assertTrue(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).isDisplayed());

        softAssert.assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).getText(),"HOME");
        softAssert.assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).getText(),"CONTACT FORM");
        softAssert.assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).getText(),"SERVICE");
        softAssert.assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).getText(),"METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> imageElements = driver.findElements(By.cssSelector("div.benefit-icon")); //
        softAssert.assertEquals(imageElements.size(), 4);

        softAssert.assertTrue(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<WebElement> benefitIconTxt = driver.findElements(By.cssSelector(".benefit-txt"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefitIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        softAssert.assertEquals(underIconsTextsActual.size(), 4);

        softAssert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(),"To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(),"To be multiplatform");
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers

        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

        softAssert.assertTrue(driver.findElement(By.xpath("//h3[@class='main-title text-center']")).getText().equalsIgnoreCase(h3));
        softAssert.assertTrue(driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText().equalsIgnoreCase(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe

        driver.switchTo().frame("iframe");
        //assertTrue(driver.findElement(By.xpath("html/body/header/div/nav/div[2]")).isDisplayed());
        //assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back

        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header

        WebElement jdiGitHubLink = driver.findElement(By.cssSelector("[class='text-center']"));

        softAssert.assertEquals(jdiGitHubLink.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL

        softAssert.assertEquals(driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"),"https://github.com/epam/JDI");

        //15.Assert that there is Left Section

        softAssert.assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        //16.Assert that there is Footer

        softAssert.assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }
}
