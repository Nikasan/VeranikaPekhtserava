package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.entities.MetalsColors;
import hw7.forms.MetalAndColorsForm;
import hw7.sections.Result;
import org.openqa.selenium.support.FindBy;


public class MetalAndColorsPage extends WebPage {

    @FindBy(id = "submit-button")
    public Button submit;

    MetalAndColorsForm form;
    Result result;

    public void fillForm(MetalsColors parameters) {
        form.fill(parameters);
    }

    public void submitForm() {
        submit.click();
    }

    public void checkForm(MetalsColors parameters) {
        result.checkLogPanel(parameters);
    }
}
