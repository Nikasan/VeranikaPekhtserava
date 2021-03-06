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

        assertTrue(resultContent.contains("Summary: " + (params.getOdd()+params.getEven())));
        assertTrue(resultContent.contains("Elements: " + String.join(", ", params.getNature())));
        assertTrue(resultContent.contains("Color: " + params.getColor()));
        assertTrue(resultContent.contains("Metal: " + params.getMetal()));
        assertTrue(resultContent.contains("Vegetables: " + String.join(", ", params.getVegetables())));
    }
}

