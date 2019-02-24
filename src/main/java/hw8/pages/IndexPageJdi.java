package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;

import hw8.entities.User;
import hw8.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

import static hw8.entities.User.PETER;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    public void login(User user) {
        loginIcon.click();
        loginForm.loginAs(PETER);
    }
}
