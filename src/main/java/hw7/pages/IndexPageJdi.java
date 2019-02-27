package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;

import hw7.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

import static hw7.entities.User.PETER;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    public void login() {
        loginIcon.click();
        loginForm.loginAs(PETER);
    }
}
