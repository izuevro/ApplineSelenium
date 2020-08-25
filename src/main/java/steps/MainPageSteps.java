package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps extends BaseSteps {

    @Step("Закрыть Pop-up баннер")
    public void stepClosePopUpButton() {
        new MainPage(driver).closePopUpButton();
    }

    @Step("Выбрать раздел \"{0}\" в главном меню")
    public void stepSelectTopMenuListItem(String itemName) {
        new MainPage(driver).selectTopMenuListItem(itemName);
    }

    @Step("Выбрать раздел \"{0}\" в подразделе")
    public void stepSelectSubMenuListItem(String subItemName) {
        new MainPage(driver).selectSubMenuListItem(subItemName);
    }
}
