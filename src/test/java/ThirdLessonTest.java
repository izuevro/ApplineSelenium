import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class ThirdLessonTest extends BaseSteps {
    @Test
    @Title("Проверка заполнения заявки на страховку путешественников")
    public void sberbankThirdTest() {
        MainPageSteps mainPageSteps = new MainPageSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        ChoiceInsurancePolicySteps choiceInsurancePolicySteps = new ChoiceInsurancePolicySteps();
        FormingInsurancePolicySteps formingInsurancePolicySteps = new FormingInsurancePolicySteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного", "Иванов");
        testData.put("Имя застрахованного", "Иван");
        testData.put("ДР застрахованного", "02.04.1993");
        testData.put("Фамилия страхуемого", "Петрова");
        testData.put("Имя страхуемого", "Анна");
        testData.put("Отчество страхуемого", "Ивановна");
        testData.put("ДР страхуемого", "01.01.1983");
        testData.put("Серия паспорта С", "1017");
        testData.put("Номер паспорта С", "100092");
        testData.put("Дата выдачи паспорта С", "08.05.2013");
        testData.put("Организация выдавшая паспорт С", "Отделом УФМС России");

        driver.get(baseUrl);
        mainPageSteps.stepClosePopUpButton();
        mainPageSteps.stepSelectTopMenuListItem("Страхование");
        mainPageSteps.stepSelectSubMenuListItem("Страхование путешественников");

        travelInsuranceSteps.stepCheckHeaderText("Страхование путешественников");
        travelInsuranceSteps.stepConfirmButtonTravelClick();

        choiceInsurancePolicySteps.stepCheckTypeOfInsuranceMinimal();
        choiceInsurancePolicySteps.stepConfirmButtonChoiceClick();

        formingInsurancePolicySteps.stepFillAllField(testData);
        formingInsurancePolicySteps.stepCheckerFields(testData);
        formingInsurancePolicySteps.stepCheckSexOfInsurer();
        formingInsurancePolicySteps.stepConfirmButtonClick();
        formingInsurancePolicySteps.stepCheckAlertTextField("При заполнении данных произошла ошибка");
    }
}
