package base.jdi.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;

public class Summary extends Section {
    @FindBy(id = "summary-block")
    public Summary summary;

    @FindBy(id="odds-selector")
    public Checklist odds;

    @FindBy(id="even-selector")
    public Checklist even;

    @FindBy(id = "calculate-button")
    public Button calculate;

//    public void culculateSummarySection(int odd, int ev){
//    odds.select(odd);
//    even.select(ev);
//    calculate.click();
//    }

}
