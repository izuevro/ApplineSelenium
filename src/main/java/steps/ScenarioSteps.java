package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    ChoiceInsurancePolicySteps choiceInsurancePolicySteps = new ChoiceInsurancePolicySteps();
    FormingInsurancePolicySteps formingInsurancePolicySteps = new FormingInsurancePolicySteps();

    @When("^закрыт Pop-up баннер$")
    public void stepClosePopUpButton() {
        mainPageSteps.stepClosePopUpButton();
    }

    @When("^выбран раздел в главном меню \"(.*)\"$")
    public void stepSelectTopMenuListItem(String itemName) {
        mainPageSteps.stepSelectTopMenuListItem(itemName);
    }

    @When("^выбран раздел в подразделе \"(.*)\"$")
    public void stepSelectSubMenuListItem(String subItemName) {
        mainPageSteps.stepSelectSubMenuListItem(subItemName);
    }

    @Then("^проверить содержимое заголовка \"(.*)\"$")
    public void stepCheckHeaderText(String text) {
        travelInsuranceSteps.stepCheckHeaderText(text);
    }

    @When("^нажать кнопку \"Оформить онлайн\"$")
    public void stepConfirmButtonTravelClick() {
        travelInsuranceSteps.stepConfirmButtonTravelClick();
    }

    @When("^выбрать тарифный план \"Минимальная\"$")
    public void stepCheckTypeOfInsuranceMinimal() {
        choiceInsurancePolicySteps.stepCheckTypeOfInsuranceMinimal();
    }

    @When("^нажать кнопку \"Оформить\"$")
    public void stepConfirmButtonChoiceClick() {
        choiceInsurancePolicySteps.stepConfirmButtonChoiceClick();
    }

    @When("^заполняются поля формы:$")
    public void stepFillAllField(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((key, value) -> formingInsurancePolicySteps.stepFillField(key, value));
    }

    @Then("^выбран пол страхователя$")
    public void stepCheckSexOfInsurer() {
        formingInsurancePolicySteps.stepCheckSexOfInsurer();
    }

    @Then("^проверка заполненных полей:$")
    public void stepCheckerFields(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((key, value) -> formingInsurancePolicySteps.stepCheckFieldFill(key, value));
    }

    @When("^нажать кнопку \"Продолжить\"$")
    public void stepConfirmButtonClick() {
        formingInsurancePolicySteps.stepConfirmButtonClick();
    }

    @Then("^проверить сообщение об ошибке - \"(.*)\"$")
    public void stepCheckAlertTextField(String text) {
        formingInsurancePolicySteps.stepCheckAlertTextField(text);
    }
}
