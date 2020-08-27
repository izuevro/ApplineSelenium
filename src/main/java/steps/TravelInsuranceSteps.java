package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps {

    @Step("Проверить содержимое заголовка")
    public void stepCheckHeaderText(String text) {
        new TravelInsurancePage(BaseSteps.getDriver()).checkHeaderText(text);
    }

    @Step("Нажать кнопку \"Оформить онлайн\"")
    public void stepConfirmButtonTravelClick() {
        new TravelInsurancePage(BaseSteps.getDriver()).confirmButtonTravelClick();
    }
}
