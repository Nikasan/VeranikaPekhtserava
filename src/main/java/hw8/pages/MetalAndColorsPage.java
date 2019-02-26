package hw8.pages;

import base.jdi.lesson1.enums.Odds;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.common.Button;
import hw8.entities.MetalsColors;
import hw8.enums.*;
import hw8.forms.MetalAndColorsForm;
import hw8.sections.Result;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MetalAndColorsPage extends WebPage {

    @FindBy(id = "submit-button")
    public Button submit;

    MetalAndColorsForm form;
    Result result;

    public void fillForm(MetalsColors parameters){
        form.fill(parameters);
    }

    public void submitForm(){
        submit.click();
    }
 public void checkForm(MetalsColors parameters){
        result.checkLogPanel(parameters);
 }
}
