package hw8.pages;

import base.jdi.lesson1.sections.LogSidebar;
import com.epam.jdi.light.elements.composite.WebPage;
import hw8.sections.Summary;

public class MetalAndColorsPage extends WebPage {

    Summary summary;
    LogSidebar log;

    public void culculateSummarySectionCheckLog(int odd, int ev) {
        summary.odds.select(odd);
        log.logSidebar.get(0).getText().equals("Summary (Odd): value changed to" + odd);
        summary.even.select(ev);
        log.logSidebar.get(0).getText().equals("Summary (Even): value changed to" + ev);
        summary.calculate.click();
        log.logSidebar.get(0).getText().equals("calculate-button:button clicked");

    }

}
