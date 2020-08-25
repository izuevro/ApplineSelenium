package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps extends BaseSteps {

    @Step("Проверить содержимое заголовка")
    public void stepCheckHeaderText(String text) {
        new TravelInsurancePage(driver).checkHeaderText(text);
    }

    @Step("Нажать кнопку \"Оформить онлайн\"")
    public void stepConfirmButtonTravelClick() {
        new TravelInsurancePage(driver).confirmButtonTravelClick();
    }
}
