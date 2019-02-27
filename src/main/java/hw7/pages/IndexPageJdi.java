package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;

import hw7.enums.Navigation;
import hw7.forms.LoginForm;
import hw7.sections.Header;
import org.openqa.selenium.support.FindBy;

import static hw7.base.EpamSite.metalsColorsPage;
import static hw7.entities.User.PETER;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;
    public Header header;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    public void login() {
        loginIcon.click();
        loginForm.loginAs(PETER);
    }

    public void openMenuItem(Navigation item){
        header.navigationBar.select(item.toString());
        metalsColorsPage.shouldBeOpened();
    }
}
