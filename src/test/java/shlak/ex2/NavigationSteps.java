//package hw6.ex2;
//
//import cucumber.api.java.After;
//import cucumber.api.java.en.Given;
//
//import static com.codeborne.selenide.Selenide.close;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static hw6.ex2.enums.HomePageInfo.HOME_PAGE_URL;
//
//// TODO Why do you have to impl of NavigationSteps?
//public class NavigationSteps {
//
//    @Given("^I am on 'HOME_PAGE'$")
//    public void goHomePage() {
//        open(HOME_PAGE_URL.value);
//        getWebDriver().manage().window().maximize();
//    }
//
//    @After
//    public void driverClose() {
//        close();
//    }
//}