package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInfoPage {
    WebDriver driver;
    By buttonNext = By.xpath("//button[contains(text(),'Далее')]");
    private By phoneNumberField = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    private String  metroStationField = "[placeholder='* Станция метро']";
    private By metroStationList = By.cssSelector(".select-search");
    private By  addressField = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private By lastNameField = By.cssSelector("[placeholder='* Фамилия']");
    private By firstNameField = By.cssSelector("[placeholder='* Имя']");
    String metroStationChoice = "//div[contains(text(), '%s')]";

    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonNext() {//находим кнопку далее, кликаем
                driver.findElement(buttonNext).click();
    }

    public void setPhoneNumber(String phoneNumber) {//находим кнопку телефон, заполняем
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(By.cssSelector(metroStationField)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroStationList));
        driver.findElement(By.xpath(String.format(metroStationChoice, metroStation))).click();
    }

    public void setAddress(String address) {
               driver.findElement(addressField).sendKeys(address);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }


}
