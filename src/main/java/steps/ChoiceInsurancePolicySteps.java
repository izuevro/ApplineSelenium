package steps;

import pages.ChoiceInsurancePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoiceInsurancePolicySteps extends BaseSteps {

    @Step("Выбрать тарифный план \"Минимальная\"")
    public void stepCheckTypeOfInsuranceMinimal() {
        new ChoiceInsurancePolicyPage(driver).checkTypeOfInsuranceMinimal();
    }

    @Step("Нажать кнопку \"Оформить\"")
    public void stepConfirmButtonChoiceClick() {
        new ChoiceInsurancePolicyPage(driver).confirmButtonChoiceClick();
    }
}
