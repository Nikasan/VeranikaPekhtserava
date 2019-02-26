package base.jdi.sections;

import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class LogSidebar extends Section {

    @FindBy(className="logs")
    public LogSidebar logSidebar;
}
