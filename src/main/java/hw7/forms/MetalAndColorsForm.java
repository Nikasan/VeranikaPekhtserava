package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import hw7.entities.MetalsColors;
import hw7.sections.Summary;

public class MetalAndColorsForm extends Form<MetalsColors> {

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public static Droplist metal;

    @JDropdown(root = "#salad-dropdown",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @FindBy(css = "#elements-checklist > p")
    public WebList natureElements;

    Summary summaryBlock;

    public void fill(MetalsColors metalsColors) {
        summaryBlock.odds.select(metalsColors.getOdd());
        summaryBlock.even.select(metalsColors.getEven());
        summaryBlock.calculate.click();
        metalsColors.getNature()
                .forEach(s -> natureElements.select(s));
        colors.select(metalsColors.getColor());
        metal.select(metalsColors.getMetal());
        vegetables.select(vegetables.getSelected());
        metalsColors.getVegetables()
                .forEach(s -> vegetables.select(s));
    }
}
