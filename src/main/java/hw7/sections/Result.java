package hw7.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import hw7.entities.MetalsColors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.testng.Assert.assertTrue;


public class Result extends Section {

    @FindBy(className = "results")
    public WebList result;

    public void checkLogPanel(MetalsColors params) {

        List<String> resultContent = new ArrayList<>();
        for (WebElement element : result) {
            resultContent.add(element.getText());
        }

        assertTrue(resultContent.contains("Summary: " + checkSummaryBock(params)));
        assertTrue(resultContent.contains("Elements: " + String.join(", ", params.getNature())));
        assertTrue(resultContent.contains("Color: " + params.getColor()));
        assertTrue(resultContent.contains("Metal: " + params.getMetal()));
        assertTrue(resultContent.contains("Vegetables: " + String.join(", ", params.getVegetables())));
    }

    private Integer getSum(MetalsColors params, boolean isOdd) {
        Integer result = 0;

        Set<Map.Entry<String, Integer>> set = isOdd
                ? params.getOdd().entrySet()
                : params.getEven().entrySet();

        for (Map.Entry<String, Integer> entry : set) {
            Integer value = entry.getValue();
            result += value;
        }
        return result;
    }

    private String checkSummaryBock(MetalsColors params) {

        Integer result;

        result = getSum(params, true) + getSum(params, false);
        return result.toString();
    }
}

