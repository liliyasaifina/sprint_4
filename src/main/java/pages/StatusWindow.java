package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StatusWindow {
    WebDriver driver;
    By orderConfirm = By.cssSelector(".Order_Modal__YZ-d3");

    public StatusWindow(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isStatusWindowDisplayed() {
        WebElement statusWindow = driver.findElement(orderConfirm);
        return statusWindow.isDisplayed();
    }
}
