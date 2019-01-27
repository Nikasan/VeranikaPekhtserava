package classWork.lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTestWithDataProvider {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {0, "dzfhbv"},
                {1, "hadbfl"},
                {2, "sdhvb"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void simpleTest(int i, String s) {
        System.out.println("int =" + i + "\n" + "String =" + s);
    }
}
