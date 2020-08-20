package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class FormingInsurancePolicyPage extends BasePage {

    @FindBy(css = "#surname_vzr_ins_0")
    WebElement surNameOfInsured;

    @FindBy(css = "#name_vzr_ins_0")
    WebElement nameOfInsured;

    @FindBy(css = "#birthDate_vzr_ins_0")
    WebElement dateOfBirdInsured;

    @FindBy(css = "#person_lastName")
    WebElement lastNameOfInsurer;

    @FindBy(css = "#person_firstName")
    WebElement firstNameOfInsurer;

    @FindBy(css = "#person_middleName")
    WebElement middleNameOfInsurer;

    @FindBy(css = "#person_birthDate")
    WebElement dateOfBirdInsurer;

    @FindBy(xpath = "//*[contains(text(), 'Женский')]")
    WebElement sexOfInsurer;

    @FindBy(css = "#passportSeries")
    WebElement passportSeriesOfInsurer;

    @FindBy(css = "#passportNumber")
    WebElement passportNumberOfInsurer;

    @FindBy(css = "#documentDate")
    WebElement docDateOfPassport;

    @FindBy(css = "#documentIssue")
    WebElement organizationIssuePassport;

    @FindBy(css = ".btn-primary")
    WebElement confirmButton;

    @FindBy(css = ".alert-form")
    WebElement alertTextField;

    private void fillField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    private String checkField(WebElement element) {
        return element.getAttribute("value");
    }

    public void fillField(String nameOfCell, String value) {
        switch (nameOfCell) {
            case "Фамилия застрахованного":
                fillField(surNameOfInsured, value);
                break;
            case "Имя застрахованного":
                fillField(nameOfInsured, value);
                break;
            case "ДР застрахованного":
                fillField(dateOfBirdInsured, value);
                break;
            case "Фамилия страхуемого":
                fillField(lastNameOfInsurer, value);
                break;
            case "Имя страхуемого":
                fillField(firstNameOfInsurer, value);
                break;
            case "Отчество страхуемого":
                fillField(middleNameOfInsurer, value);
                break;
            case "ДР страхуемого":
                fillField(dateOfBirdInsurer, value);
                break;
            case "Серия паспорта С":
                fillField(passportSeriesOfInsurer, value);
                break;
            case "Номер паспорта С":
                fillField(passportNumberOfInsurer, value);
                break;
            case "Дата выдачи паспорта С":
                fillField(docDateOfPassport, value);
                break;
            case "Организация выдавшая паспорт С":
                fillField(organizationIssuePassport, value);
                break;
            default:
                throw new AssertionError("Поле '" + nameOfCell + "' не объявлено на странице");
        }
    }

    public String getFillField(String nameOfCell) {
        switch (nameOfCell) {
            case "Фамилия застрахованного":
                return checkField(surNameOfInsured);
            case "Имя застрахованного":
                return checkField(nameOfInsured);
            case "ДР застрахованного":
                return checkField(dateOfBirdInsured);
            case "Фамилия страхуемого":
                return checkField(lastNameOfInsurer);
            case "Имя страхуемого":
                return checkField(firstNameOfInsurer);
            case "Отчество страхуемого":
                return checkField(middleNameOfInsurer);
            case "ДР страхуемого":
                return checkField(dateOfBirdInsurer);
            case "Серия паспорта С":
                return checkField(passportSeriesOfInsurer);
            case "Номер паспорта С":
                return checkField(passportNumberOfInsurer);
            case "Дата выдачи паспорта С":
                return checkField(docDateOfPassport);
            case "Организация выдавшая паспорт С":
                return checkField(organizationIssuePassport);
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkSexOfInsurer() {
        sexOfInsurer.click();
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

    public void checkAlertTextField(String text) {
        assertEquals(text, alertTextField.getText());
    }

    public FormingInsurancePolicyPage(WebDriver driver) {
        super(driver);
    }
}