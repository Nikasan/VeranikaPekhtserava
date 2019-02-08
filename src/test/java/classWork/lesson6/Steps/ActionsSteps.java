package classWork.lesson6.Steps;

import base.Selenide.IndexPage;
import cucumber.api.java.en.When;

public class ActionsSteps {

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAsUserEpamWithPassword(String username, String password) {
        new IndexPage().login(username,password);

    }
}
