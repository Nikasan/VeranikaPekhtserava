package hw6.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import hw6.enums.TableNames;
import hw6.enums.UserTablePageInfo;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class UserTablePage {
    @FindBy(css = "tr > td:first-child")
    private ElementsCollection numbers;

    @FindBy(css = "tr > td > select")
    private ElementsCollection typeDropdowns;

    @FindBy(css = "tr > td > a")
    private ElementsCollection usernames;

    @FindBy(css = "tr > td > img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "div.user-descr > span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection vipCheckboxes;

    @FindBy(css = "ul.logs > li:first-child")
    private SelenideElement log;

    public void checkTitle(UserTablePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void checkUserTableContainsElements(DataTable dataTable){
        List<List<String>> table = dataTable.raw();
        for (int i = 0; i < table.size()-1 ; i++) {
            numbers.get(i).shouldHave(text(table.get(i + 1).get(0)));
            usernames.get(i).shouldHave(text(table.get(i + 1).get(1)));
            descriptionTexts.get(i).shouldHave(text(table.get(i + 1).get(2)));
        }
    }

    public void checkNumberTypeDropdowns(int number){
        for (int i = 0; i < number ; i++) {
            numbers.get(i).shouldBe(visible);
            typeDropdowns.get(i).shouldBe(visible);
        }
        numbers.shouldHaveSize(number);
        typeDropdowns.shouldHaveSize(number);
    }

    public void checkUsernames(int number){
        for (SelenideElement username : usernames) {
            username.shouldBe(visible);
        }
        usernames.shouldHaveSize(number);
    }

    public void checkDescriptionImages(int number){
        for (SelenideElement descriptionImage : descriptionImages) {
            descriptionImage.shouldBe(visible);
        }
        descriptionImages.shouldHaveSize(number);
    }

    public void checkTextsUnderImages(int number){
        for (SelenideElement descriptionText : descriptionTexts) {
            descriptionText.shouldBe(visible);
        }
        descriptionTexts.shouldHaveSize(number);
    }

    public void checkVipCheckboxes(int number){
        for (SelenideElement vipCheckbox : vipCheckboxes) {
            vipCheckbox.shouldBe(visible);
        }
        vipCheckboxes.shouldHaveSize(number);
    }

    public void selectVipBox(TableNames name){
        for (SelenideElement vip : vipCheckboxes) {
            if (name.toString().toLowerCase().contains(vip.getAttribute("id"))){
                vip.click();
            }
        }
    }

    public void checkLogForVipBox(String message){
        log.shouldHave(text(message));
    }

    public void openDropdownColumnTypeForUser(TableNames name){
        usernames.findBy(text(name.toString())).$x("../../td/select").click();
    }

    public void checkUserRoleDropdownHasValues(List<String> values){
        ElementsCollection statuses = typeDropdowns.get(0).$$("option");
        for (int i = 0; i < values.size(); i++) {
            statuses.get(i).shouldHave(text(values.get(i)));
        }

//        for(String value : values){
//            statuses.contains(value);
//        }
        System.out.println(statuses.toString());

//       Additional method
//        for(String value : values){
//            typeDropdowns.contains(value);
//        }
    }
}
