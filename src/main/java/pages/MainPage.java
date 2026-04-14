package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPage {

    WebDriver driver;
    By buttonFirst = By.cssSelector("button[class='Button_Button__ra12g']");
    By buttonCookie = By.id("rcc-confirm-button");
    By buttonSecond = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private String questionLocator = ".accordion__button";
    private String answerLocator = "[id^='accordion__panel-'] > p";

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

    public void clickQuestion(int index) {
        List<WebElement> questions = driver.findElements(By.cssSelector(questionLocator));
        questions.get(index).click();
    }

    public String getQuestionText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(questionLocator)));
        List<WebElement> questions = driver.findElements(By.cssSelector(questionLocator));
        return questions.get(index).getText();
    }

    public String getAnswerText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(answerLocator)));
        List<WebElement> answers = driver.findElements(By.cssSelector(answerLocator));
        return answers.get(index).getText();
    }
}