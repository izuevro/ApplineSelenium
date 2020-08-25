package steps;

import pages.FormingInsurancePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FormingInsurancePolicySteps extends BaseSteps {

    @Step("Заполнить поле \"{0}\"")
    public void stepFillField(String nameOfCell, String value) {
        new FormingInsurancePolicyPage(driver).fillField(nameOfCell, value);
    }

    @Step("Заполнить все поля")
    public void stepFillAllField(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Проверить поле \"{0}\"")
    public void stepCheckFieldFill(String nameOfCell, String exp) {
        FormingInsurancePolicyPage formingInsurancePolicyPage = new FormingInsurancePolicyPage(driver);
        assertEquals(exp, formingInsurancePolicyPage.getFillField(nameOfCell));
    }

    @Step("Проверить все поля")
    public void stepCheckerFields(HashMap<String, String> data) {
        FormingInsurancePolicyPage formingInsurancePolicyPage = new FormingInsurancePolicyPage(driver);
        data.forEach((key, value) -> assertEquals(value, formingInsurancePolicyPage.getActualValue(key)));
    }

    @Step("Проверить пол страхователя")
    public void stepCheckSexOfInsurer() {
        new FormingInsurancePolicyPage(driver).checkSexOfInsurer();
    }

    @Step("Нажать кнопку \"Продолжить\"")
    public void stepConfirmButtonClick() {
        new FormingInsurancePolicyPage(driver).confirmButtonClick();
    }

    @Step("Проверить сообщение об ошибке")
    public void stepCheckAlertTextField(String text) {
        new FormingInsurancePolicyPage(driver).checkAlertTextField(text);
    }
}
