package hw2.ex2;

import base.SeleniumBase;
import hw2.DriverFactory.DriverClass;
import hw2.DriverFactory.DriverFactory;
import hw2.DriverFactory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleTestHomePage4 extends SeleniumBase {

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

    @Test(groups = {"Regression","Smoke"})
    public void TestHomePageItemsHW11() {

        //2 Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //3.Perform login
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsName = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("ul.uui-navigation:nth-child(3) > li"));
        assertEquals(itemsName.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).isDisplayed());

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).getText(), "HOME");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).getText(), "CONTACT FORM");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).getText(), "SERVICE");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imageElements = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("div.benefit-icon")); //
        assertEquals(imageElements.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconTxt = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector(".benefit-txt"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefitIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual.size(), 4);

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().equalsIgnoreCase(h3));
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().equalsIgnoreCase(mainHeader));

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = DriverManager.getDriver().getRemoteWebDriver().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        DriverManager.getDriver().getRemoteWebDriver().switchTo().frame("iframe");

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back
        DriverManager.getDriver().getRemoteWebDriver().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdiGitHubLink = DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[class='text-center']"));

        assertEquals(jdiGitHubLink.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.name("navigation-sidebar")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".footer-bg")).isDisplayed());
        //DriverManager.getDriver().getRemoteWebDriver().close();
    }

    @Test(groups = {"Regression","Smoke"})
    public void TestHomePageItemsHW12() {

        //2 Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //3.Perform login
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsName = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("ul.uui-navigation:nth-child(3) > li"));
        assertEquals(itemsName.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).isDisplayed());

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).getText(), "HOME");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).getText(), "CONTACT FORM");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).getText(), "SERVICE");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imageElements = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("div.benefit-icon")); //
        assertEquals(imageElements.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconTxt = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector(".benefit-txt"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefitIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual.size(), 4);

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().equalsIgnoreCase(h3));
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().equalsIgnoreCase(mainHeader));

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = DriverManager.getDriver().getRemoteWebDriver().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        DriverManager.getDriver().getRemoteWebDriver().switchTo().frame("iframe");

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back
        DriverManager.getDriver().getRemoteWebDriver().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdiGitHubLink = DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[class='text-center']"));

        assertEquals(jdiGitHubLink.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.name("navigation-sidebar")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }

    @Test(groups = {"Regression","Smoke"})
    public void TestHomePageItemsHW13() {

        //2 Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //3.Perform login
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("#user-name")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsName = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("ul.uui-navigation:nth-child(3) > li"));
        assertEquals(itemsName.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).isDisplayed());

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(1)")).getText(), "HOME");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2)")).getText(), "CONTACT FORM");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(3)")).getText(), "SERVICE");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imageElements = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector("div.benefit-icon")); //
        assertEquals(imageElements.size(), 4);

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconTxt = DriverManager.getDriver().getRemoteWebDriver().findElements(By.cssSelector(".benefit-txt"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefitIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual.size(), 4);

        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(1)")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(2)")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(3)")).getText(), "To be multiplatform");
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("div.col-sm-3:nth-child(4)")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().equalsIgnoreCase(h3));
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().equalsIgnoreCase(mainHeader));

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = DriverManager.getDriver().getRemoteWebDriver().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        DriverManager.getDriver().getRemoteWebDriver().switchTo().frame("iframe");

        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back
        DriverManager.getDriver().getRemoteWebDriver().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdiGitHubLink = DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector("[class='text-center']"));

        assertEquals(jdiGitHubLink.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(DriverManager.getDriver().getRemoteWebDriver().findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.name("navigation-sidebar")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(DriverManager.getDriver().getRemoteWebDriver().findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }
}