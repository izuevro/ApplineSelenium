package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChoiceInsurancePolicyPage extends BasePage {

    @FindBy(css = ".btn-primary")
    WebElement confirmButtonChoice;

    public void checkTypeOfInsuranceMinimal() {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[contains(text(), 'Минимальная')]"))).isSelected();
    }

    public void confirmButtonChoiceClick() {
        confirmButtonChoice.click();
    }

    public ChoiceInsurancePolicyPage(WebDriver driver) {
        super(driver);
    }
}