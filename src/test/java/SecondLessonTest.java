import org.junit.Test;
import pages.ChoiceInsurancePolicyPage;
import pages.FormingInsurancePolicyPage;
import pages.MainPage;
import pages.TravelInsurancePage;

import static org.junit.Assert.assertEquals;

public class SecondLessonTest extends BaseTest {

    @Test
    public void sberbankSecondTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.closePopUpButton();
        mainPage.selectTopMenuListItem("Страхование");
        mainPage.selectSubMenuListItem("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.checkHeaderText("Страхование путешественников");
        travelInsurancePage.confirmButtonTravelClick();

        ChoiceInsurancePolicyPage choiceInsurancePolicyPage = new ChoiceInsurancePolicyPage(driver);
        choiceInsurancePolicyPage.checkTypeOfInsuranceMinimal();
        choiceInsurancePolicyPage.confirmButtonChoiceClick();

        FormingInsurancePolicyPage formingInsurancePolicyPage = new FormingInsurancePolicyPage(driver);
        formingInsurancePolicyPage.fillField("Фамилия застрахованного", "Иванов");
        formingInsurancePolicyPage.fillField("Имя застрахованного", "Иван");
        formingInsurancePolicyPage.fillField("ДР застрахованного", "02.04.1993");
        formingInsurancePolicyPage.fillField("Фамилия страхуемого", "Петрова");
        formingInsurancePolicyPage.fillField("Имя страхуемого", "Анна");
        formingInsurancePolicyPage.fillField("Отчество страхуемого", "Ивановна");
        formingInsurancePolicyPage.fillField("ДР страхуемого", "01.01.1983");
        formingInsurancePolicyPage.fillField("Серия паспорта С", "1017");
        formingInsurancePolicyPage.fillField("Номер паспорта С", "100092");
        formingInsurancePolicyPage.fillField("Дата выдачи паспорта С", "08.05.2013");
        formingInsurancePolicyPage.fillField("Организация выдавшая паспорт С", "Отделом УФМС России");

        formingInsurancePolicyPage.checkSexOfInsurer();

        assertEquals("Иванов", formingInsurancePolicyPage
                .getFillField("Фамилия застрахованного"));
        assertEquals("Иван", formingInsurancePolicyPage
                .getFillField("Имя застрахованного"));
        assertEquals("02.04.1993", formingInsurancePolicyPage
                .getFillField("ДР застрахованного"));
        assertEquals("Петрова", formingInsurancePolicyPage
                .getFillField("Фамилия страхуемого"));
        assertEquals("Анна", formingInsurancePolicyPage
                .getFillField("Имя страхуемого"));
        assertEquals("Ивановна", formingInsurancePolicyPage
                .getFillField("Отчество страхуемого"));
        assertEquals("01.01.1983", formingInsurancePolicyPage
                .getFillField("ДР страхуемого"));
        assertEquals("1017", formingInsurancePolicyPage
                .getFillField("Серия паспорта С"));
        assertEquals("100092", formingInsurancePolicyPage
                .getFillField("Номер паспорта С"));
        assertEquals("08.05.2013", formingInsurancePolicyPage
                .getFillField("Дата выдачи паспорта С"));
        assertEquals("Отделом УФМС России", formingInsurancePolicyPage
                .getFillField("Организация выдавшая паспорт С"));

        formingInsurancePolicyPage.confirmButtonClick();
        formingInsurancePolicyPage.checkAlertTextField("При заполнении данных произошла ошибка");
    }
}