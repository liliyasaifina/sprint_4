package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    WebDriver driver;
    By buttonFirst = By.cssSelector("button[class='Button_Button__ra12g']");
    By buttonCookie = By.id("rcc-confirm-button");
    By buttonSecond = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonFirst() {
                driver.findElement(buttonFirst).click(); //    находим кнопку заказать и кликаем
    }

    public void clickButtonCookie(){
        driver.findElement(buttonCookie).click();
    }

    public void clickButtonSecond() {
        driver.findElement(buttonSecond).click();
    }
}