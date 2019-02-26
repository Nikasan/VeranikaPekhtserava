package hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import hw8.entities.MetalsColors;
import hw8.sections.Summary;

import java.util.Map;
import java.util.Set;

public class MetalAndColorsForm extends Form {

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
    Summary summaryblock;

    public void fill(MetalsColors params) {

        Set<Map.Entry<String, Integer>> odd = params.getOdd().entrySet();
        for (Map.Entry<String, Integer> entry : odd) {
            String key = entry.getKey();
            summaryblock.odds.select(key);
        }

        Set<Map.Entry<String, Integer>> even = params.getEven().entrySet();
        for (Map.Entry<String, Integer> entry : even) {
            String key = entry.getKey();
            summaryblock.even.select(key);
        }

        summaryblock.calculate.click();

        params.getNatureElements()
                .forEach(s -> natureElements.select(s));

        colors.select(params.getColor());

        metal.select(params.getMetal());

        vegetables.select(vegetables.getSelected());
        params.getVegetables()
                .forEach(s -> vegetables.select(s));
    }
}
