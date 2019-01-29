package hw2_2.hw2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ex2_3 extends SeleniumBase {

    private ChromeOptions options;

    @BeforeClass
    public void beforeClass() {

        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        DriverClass driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);

        DriverManager.getDriver().getRwd().manage().window().maximize();
        DriverManager.getDriver().getRwd().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        String handle = DriverManager.getDriver().getRwd().getWindowHandle();
        DriverManager.getDriver().getRwd().switchTo().window(handle);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        DriverManager.getDriver().getRwd().close();
    }


    @Test(groups = "Regression")
    public void TestHomePageItemsHW1_1() {

        //1.Open test site by URL

        DriverManager.getDriver().getRwd().navigate().to("http://epam.github.io/JDI/index.html");

        //2 Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //3.Perform login

        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined

        assertEquals(DriverManager.getDriver().getRwd().findElement(By.xpath(".//div[@class = 'profile-photo']/span[@ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = DriverManager.getDriver().getRwd().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(itemsName.size(), 4);

        List<String> itemNamesExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> itemsNamesActual = new LinkedList<String>();
        for (WebElement element : itemsName) {
            itemsNamesActual.add(element.getText());
        }
        assertEquals(itemsNamesActual, itemNamesExpected);

        //7 Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> imageElements = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/div[@class='benefit-icon' and 1]"));
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
        List<WebElement> benefirIconTxt = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/span[@class='benefit-txt' and 1]"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefirIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual, underIconsTextsEXpected);

        //9 Assert a text of the main headers

        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "LOREM IPSUM DOLOR SIT AMET, ";
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().contains(h3));
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().contains(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = DriverManager.getDriver().getRwd().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe

        WebElement iframeSwitch = DriverManager.getDriver().getRwd().findElement(By.id("iframe"));
        DriverManager.getDriver().getRwd().switchTo().frame(iframeSwitch);
        System.out.println("Switched");
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("html/body/header/div/nav/div[2]")).isDisplayed());
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.id("epam_logo")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back

        DriverManager.getDriver().getRwd().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdi_github_link = DriverManager.getDriver().getRwd().findElement(By.cssSelector("h3.text-center:nth-child(3) > a:nth-child(1)"));
        assertEquals(jdi_github_link.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL

        assertEquals(jdi_github_link.getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".uui-side-bar > div:nth-child(1)")).isDisplayed());

        //16.Assert that there is Footer

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector("body > footer:nth-child(3)")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void TestHomePageItemsHW1_2() {

        //1.Open test site by URL

        DriverManager.getDriver().getRwd().navigate().to("http://epam.github.io/JDI/index.html");

        //2 Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //3.Perform login

        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined

        assertEquals(DriverManager.getDriver().getRwd().findElement(By.xpath(".//div[@class = 'profile-photo']/span[@ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = DriverManager.getDriver().getRwd().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(itemsName.size(), 4);

        List<String> itemNamesExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> itemsNamesActual = new LinkedList<String>();
        for (WebElement element : itemsName) {
            itemsNamesActual.add(element.getText());
        }
        assertEquals(itemsNamesActual, itemNamesExpected);

        //7 Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> imageElements = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/div[@class='benefit-icon' and 1]"));
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
        List<WebElement> benefirIconTxt = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/span[@class='benefit-txt' and 1]"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefirIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual, underIconsTextsEXpected);

        //9 Assert a text of the main headers

        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "LOREM IPSUM DOLOR SIT AMET, ";
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().contains(h3));
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().contains(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = DriverManager.getDriver().getRwd().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe


        WebElement iframeSwitch = DriverManager.getDriver().getRwd().findElement(By.id("iframe"));
        DriverManager.getDriver().getRwd().switchTo().frame(iframeSwitch);
        System.out.println("Switched");
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("html/body/header/div/nav/div[2]")).isDisplayed());
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.id("epam_logo")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back

        DriverManager.getDriver().getRwd().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdi_github_link = DriverManager.getDriver().getRwd().findElement(By.cssSelector("h3.text-center:nth-child(3) > a:nth-child(1)"));
        assertEquals(jdi_github_link.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL

        assertEquals(jdi_github_link.getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".uui-side-bar > div:nth-child(1)")).isDisplayed());

        //16.Assert that there is Footer

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector("body > footer:nth-child(3)")).isDisplayed());
    }

    @Test(groups = "Smoke")
    public void TestHomePageItemsHW1_3() {

        //1.Open test site by URL

        DriverManager.getDriver().getRwd().navigate().to("http://epam.github.io/JDI/index.html");

        //2 Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //3.Perform login

        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='user-icon']")).click();
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        DriverManager.getDriver().getRwd().findElement(By.cssSelector("[id='login-button']")).click();

        //4.Assert User name in the left-top side of screen that user is loggined

        assertEquals(DriverManager.getDriver().getRwd().findElement(By.xpath(".//div[@class = 'profile-photo']/span[@ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5.Assert Browser title

        assertEquals(DriverManager.getDriver().getRwd().getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> itemsName = DriverManager.getDriver().getRwd().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(itemsName.size(), 4);

        List<String> itemNamesExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> itemsNamesActual = new LinkedList<String>();
        for (WebElement element : itemsName) {
            itemsNamesActual.add(element.getText());
        }
        assertEquals(itemsNamesActual, itemNamesExpected);

        //7 Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> imageElements = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/div[@class='benefit-icon' and 1]"));
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
        List<WebElement> benefirIconTxt = DriverManager.getDriver().getRwd().findElements(By.xpath("//div[@class='benefit' and 1]/span[@class='benefit-txt' and 1]"));
        List<String> underIconsTextsActual = new LinkedList<String>();
        for (WebElement element : benefirIconTxt) {
            underIconsTextsActual.add(element.getText());
        }
        assertEquals(underIconsTextsActual, underIconsTextsEXpected);

        //9 Assert a text of the main headers

        String h3 = "EPAM FRAMEWORK WISHES…";
        String mainHeader = "LOREM IPSUM DOLOR SIT AMET, ";
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//h3[@class='main-title text-center']")).getText().contains(h3));
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("//p[@class='main-txt text-center']")).getText().contains(mainHeader));

        //10 Assert that there is the iframe in the center of page

        WebElement iframe = DriverManager.getDriver().getRwd().findElement(By.tagName("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe


        WebElement iframeSwitch = DriverManager.getDriver().getRwd().findElement(By.id("iframe"));
        DriverManager.getDriver().getRwd().switchTo().frame(iframeSwitch);
        System.out.println("Switched");
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.xpath("html/body/header/div/nav/div[2]")).isDisplayed());
        //assertTrue(DriverManager.getDriver().getRwd().findElement(By.id("epam_logo")).isDisplayed());
        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12.Switch to original window back

        DriverManager.getDriver().getRwd().switchTo().defaultContent();

        //13.Assert a text of the sub header
        WebElement jdi_github_link = DriverManager.getDriver().getRwd().findElement(By.cssSelector("h3.text-center:nth-child(3) > a:nth-child(1)"));
        assertEquals(jdi_github_link.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL

        assertEquals(jdi_github_link.getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector(".uui-side-bar > div:nth-child(1)")).isDisplayed());

        //16.Assert that there is Footer

        assertTrue(DriverManager.getDriver().getRwd().findElement(By.cssSelector("body > footer:nth-child(3)")).isDisplayed());
    }

}