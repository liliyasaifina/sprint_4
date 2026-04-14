package pages;

import org.openqa.selenium.*;


public class StatusWindow {
    WebDriver driver;
    By orderConfirm = By.xpath("//button[text()='Посмотреть статус']");

   public StatusWindow(WebDriver driver) {
        this.driver = driver;
   }

   public boolean isStatusWindowDisplayed() {
       WebElement statusWindow = driver.findElement(orderConfirm);
        return statusWindow.isDisplayed();
   }

}


