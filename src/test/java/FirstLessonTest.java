import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FirstLessonTest {
    public WebDriver driver;

    @Before
    public void chromeInit() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void sberbankFirstTest() {
        driver.get("http://www.sberbank.ru/ru/person");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Закрыть pop-up окно и перейти в раздел "Страхование - Страхование путешественников"
        driver.findElement(By.cssSelector(".kitt-cookie-warning__close")).click();
        driver.findElement(By.xpath("//label[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Страхование путешественников')]")).click();
        // Проверить наличие на странице заголовка "Страхование путешественников"
        WebElement header = driver.findElements(By.cssSelector(".kit-row h1")).get(1);
        assertEquals("Страхование путешественников", header.getText());
        // Нажать кнопку "Оформить онлайн"
        driver.findElement(By.cssSelector(".kit-button_default")).click();
        // Проверить, что выбрана страховая защита "Минимальная"
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[contains(text(), 'Минимальная')]"))).isSelected();
        // Нажать "Оформить"
        driver.findElement(By.cssSelector(".btn-primary")).click();

        // Заполнить поля блока "Застрахованные" и проверить результат заполнения
        WebElement surnameVzr = driver.findElement(By.cssSelector("#surname_vzr_ins_0"));
        surnameVzr.sendKeys("Иванов");
        assertEquals("Иванов", surnameVzr.getAttribute("value"));

        WebElement nameVzr = driver.findElement(By.cssSelector("#name_vzr_ins_0"));
        nameVzr.sendKeys("Иван");
        assertEquals("Иван", nameVzr.getAttribute("value"));

        WebElement birthDateVzr = driver.findElement(By.cssSelector("#birthDate_vzr_ins_0"));
        birthDateVzr.sendKeys("02.04.1993");
        assertEquals("02.04.1993", birthDateVzr.getAttribute("value"));

        // Заполнить поля блока "Страхователь" и проверить результат заполнения
        WebElement personLastName = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("#person_lastName")));
        //WebElement personLastName = driver.findElement(By.cssSelector("#person_lastName"));
        personLastName.click();
        personLastName.sendKeys("Петрова");
        assertEquals("Петрова", personLastName.getAttribute("value"));

        WebElement personFirstName = driver.findElement(By.cssSelector("#person_firstName"));
        personFirstName.click();
        personFirstName.sendKeys("Анна");
        assertEquals("Анна", personFirstName.getAttribute("value"));

        WebElement personMiddleName = driver.findElement(By.cssSelector("#person_middleName"));
        personMiddleName.click();
        personMiddleName.sendKeys("Ивановна");
        assertEquals("Ивановна", personMiddleName.getAttribute("value"));

        WebElement personBirthDate = driver.findElement(By.cssSelector("#person_birthDate"));
        personBirthDate.click();
        personBirthDate.sendKeys("01.01.1983");
        assertEquals("01.01.1983", personBirthDate.getAttribute("value"));

        // Заполнить поля блока "Паспортные данные" и проверить результат заполнения
        WebElement passportSeries = driver.findElement(By.cssSelector("#passportSeries"));
        passportSeries.click();
        passportSeries.sendKeys("1017");
        assertEquals("1017", passportSeries.getAttribute("value"));

        driver.findElement(By.xpath("//*[contains(text(), 'Женский')]")).click();

        WebElement passportNumber = driver.findElement(By.cssSelector("#passportNumber"));
        passportNumber.click();
        passportNumber.sendKeys("100092");
        assertEquals("100092", passportNumber.getAttribute("value"));

        WebElement documentDate = driver.findElement(By.cssSelector("#documentDate"));
        documentDate.click();
        documentDate.sendKeys("08.05.2013");
        assertEquals("08.05.2013", documentDate.getAttribute("value"));

        WebElement documentIssue = driver.findElement(By.cssSelector("#documentIssue"));
        documentIssue.click();
        documentIssue.sendKeys("Отделом УФМС России");
        assertEquals("Отделом УФМС России", documentIssue.getAttribute("value"));

        // Нажать кнопку "Продолжить" и проверить текстовку сообщения об ошибке
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.cssSelector(".alert-form")).getText());

        driver.quit();
    }
}