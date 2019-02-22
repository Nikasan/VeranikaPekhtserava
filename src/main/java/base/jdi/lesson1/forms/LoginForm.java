package base.jdi.lesson1.forms;

import base.jdi.lesson1.entities.User;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(css = "[id='name']")
    private TextField login;

    @FindBy(css = "[id='password']")
    private TextField password;

    @FindBy(css = "[id='login-button']")
    private Button submit;
}
