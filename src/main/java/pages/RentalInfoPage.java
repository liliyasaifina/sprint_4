package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentalInfoPage {
    WebDriver driver;
    By buttonOrder = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/button[2]");
    private By commentsField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    By colour = By.id("black");
    private By periodFieldChoice = By.xpath("//div[@role='option'][contains(text(),'сутки')]");
    private By periodField = By.cssSelector(".Dropdown-control");
    private By dateFieldChoice = By.cssSelector("div[aria-label='Choose среда, 15-е апреля 2026 г.']");
    private By dateField = By.cssSelector("input[placeholder='* Когда привезти самокат']");


    public RentalInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }
    public void setComments(String comment) {
        driver.findElement(commentsField).sendKeys(comment);
    }
    public void setColour() {
        driver.findElement(colour).click();
    }
    public void setRentalPeriod() {
        driver.findElement(periodFieldChoice).click();
    }
    public void clickRentalPeriodField() {
        driver.findElement(periodField).click();
    }
    public void setDate() {
        driver.findElement(dateFieldChoice).click();
    }
    public void clickDateField() {
        driver.findElement(dateField).click();
    }
}
