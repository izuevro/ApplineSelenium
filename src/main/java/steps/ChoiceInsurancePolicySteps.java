package steps;

import pages.ChoiceInsurancePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoiceInsurancePolicySteps {

    @Step("Выбрать тарифный план \"Минимальная\"")
    public void stepCheckTypeOfInsuranceMinimal() {
        new ChoiceInsurancePolicyPage(BaseSteps.getDriver()).checkTypeOfInsuranceMinimal();
    }

    @Step("Нажать кнопку \"Оформить\"")
    public void stepConfirmButtonChoiceClick() {
        new ChoiceInsurancePolicyPage(BaseSteps.getDriver()).confirmButtonChoiceClick();
    }
}
