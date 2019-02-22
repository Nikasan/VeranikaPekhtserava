package base.jdi.lesson1.pages;

import base.jdi.lesson1.entities.User;
import base.jdi.lesson1.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;




public class IndexPageJdi extends WebPage {

    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;


    public void login(User user){
        loginIcon.click();
        loginForm.loginAs(user);
    }

}