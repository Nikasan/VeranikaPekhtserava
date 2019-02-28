package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw8.base.EpamSite;
import hw8.entities.MetalsColors;
import org.testng.annotations.*;
import java.util.Map;

import static hw8.base.EpamSite.indexPageJdi;
import static hw8.base.EpamSite.metalsColorsPage;
import static hw8.enums.Navigation.METALS_COLORS;

public class JdiSimpleExample {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(EpamSite.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        indexPageJdi.open();
        indexPageJdi.login();
        indexPageJdi.openMenuItem(METALS_COLORS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        indexPageJdi.logout();
        indexPageJdi.refresh();

    }
    @DataProvider
    public Object[][] getDataFromLoader() {
        Map<String, MetalsColors> map = Parser.getData();

        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();
        Object[][] result = new Object[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            result[i][0] = keys[i];
            result[i][1] = values[i];
        }
        return result;
    }

    @Test(dataProvider = "getDataFromLoader")
    public void simpleJdiTest(String key, MetalsColors parameters){

     metalsColorsPage.fillForm(parameters);
     metalsColorsPage.submitForm();
     metalsColorsPage.checkForm(parameters);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
