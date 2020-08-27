package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    @Step("Закрыть Pop-up баннер")
    public void stepClosePopUpButton() {
        new MainPage(BaseSteps.getDriver()).closePopUpButton();
    }

    @Step("Выбрать раздел \"{0}\" в главном меню")
    public void stepSelectTopMenuListItem(String itemName) {
        new MainPage(BaseSteps.getDriver()).selectTopMenuListItem(itemName);
    }

    @Step("Выбрать раздел \"{0}\" в подразделе")
    public void stepSelectSubMenuListItem(String subItemName) {
        new MainPage(BaseSteps.getDriver()).selectSubMenuListItem(subItemName);
    }
}
