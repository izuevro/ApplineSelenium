package steps;

import pages.FormingInsurancePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FormingInsurancePolicySteps {

    @Step("Заполнить поле \"{0}\"")
    public void stepFillField(String nameOfCell, String value) {
        new FormingInsurancePolicyPage(BaseSteps.getDriver()).fillField(nameOfCell, value);
    }

    @Step("Заполнить все поля")
    public void stepFillAllField(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Проверить поле \"{0}\"")
    public void stepCheckFieldFill(String nameOfCell, String exp) {
        FormingInsurancePolicyPage formingInsurancePolicyPage = new FormingInsurancePolicyPage(BaseSteps.getDriver());
        assertEquals(exp, formingInsurancePolicyPage.getFillField(nameOfCell));
    }

    @Step("Проверить все поля")
    public void stepCheckerFields(HashMap<String, String> data) {
        FormingInsurancePolicyPage formingInsurancePolicyPage = new FormingInsurancePolicyPage(BaseSteps.getDriver());
        data.forEach((key, value) -> assertEquals(value, formingInsurancePolicyPage.getActualValue(key)));
    }

    @Step("Проверить пол страхователя")
    public void stepCheckSexOfInsurer() {
        new FormingInsurancePolicyPage(BaseSteps.getDriver()).checkSexOfInsurer();
    }

    @Step("Нажать кнопку \"Продолжить\"")
    public void stepConfirmButtonClick() {
        new FormingInsurancePolicyPage(BaseSteps.getDriver()).confirmButtonClick();
    }

    @Step("Проверить сообщение об ошибке")
    public void stepCheckAlertTextField(String text) {
        new FormingInsurancePolicyPage(BaseSteps.getDriver()).checkAlertTextField(text);
    }
}
