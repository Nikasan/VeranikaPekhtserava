package hw7.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.base.TextAreaElement;
import org.openqa.selenium.support.FindBy;

public class LogSidebar extends Section {

    @FindBy(className="logs")
    public TextAreaElement logSidebar;
}
