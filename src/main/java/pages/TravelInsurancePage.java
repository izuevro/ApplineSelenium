package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class TravelInsurancePage extends BasePage {
    @FindBy(css = ".kit-button_default")
    WebElement confirmButtonTravel;

    public void checkHeaderText(String text) {
        WebElement header = driver.findElements(By.cssSelector(".kit-row h1")).get(1);
        assertEquals("Текст не найден", text, header.getText());
    }

    public void confirmButtonTravelClick() {
        confirmButtonTravel.click();
    }

    public TravelInsurancePage(WebDriver driver) {
        super(driver);
    }
}