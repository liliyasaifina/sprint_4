package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderWindow {
    WebDriver driver;
    By buttonYes = By.cssSelector("div[class='Order_Modal__YZ-d3'] button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    public ConfirmOrderWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonYes() {
               driver.findElement(buttonYes).click();
    }

}
