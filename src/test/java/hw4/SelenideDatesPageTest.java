package hw4;

import com.codeborne.selenide.Selenide;
import hw4.base.SelenideBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideDatesPageTest extends SelenideBase {
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPage.class);
    }

    @Test
    public void simpleTest() {

        //2
        Selenide.open("https://epam.github.io/JDI/index.html");

        //3
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        $("#user-name").shouldHave(text("PITER CHAILOVSKII"));
        //5
        close();
    }

}
