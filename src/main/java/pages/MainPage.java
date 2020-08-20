package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = ".kitt-top-menu__list")
    WebElement topMenuList;

    public void selectTopMenuListItem(String itemName) {
        topMenuList.findElement(By.xpath("//label[contains(text(), '" + itemName + "')]")).click();
    }

    public void selectSubMenuListItem(String subItemName) {
        driver.findElement(By.xpath("//a[contains(text(), '" + subItemName + "')]")).click();
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}