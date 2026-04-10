package steps;

import org.openqa.selenium.WebDriver;
import pages.PersonalInfoPage;

public class FillPersonalInfo {
    WebDriver driver;
    PersonalInfoPage personalInfoPage;

    public FillPersonalInfo(WebDriver driver) {
        this.driver = driver;
        this.personalInfoPage = new PersonalInfoPage(driver);
    }
public void setPersonalInfo(String firstName, String lastName, String address, String metroStation, String phoneNumber){

    personalInfoPage.setFirstName(firstName);
    //            находим поле фамилия заполняем
    personalInfoPage.setLastName(lastName);
    //            находим поле адрес, заполняем
    personalInfoPage.setAddress(address);
//            находим кнопку станция метро, кликаем
    personalInfoPage.setMetroStation(metroStation);
    //            находим кнопку телефон, заполняем
    personalInfoPage.setPhoneNumber(phoneNumber);
    //             находим кнопку далее, кликаем
    personalInfoPage.clickButtonNext();
}
}
