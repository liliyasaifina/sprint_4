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
   personalInfoPage.setLastName(lastName);
   personalInfoPage.setAddress(address);
   personalInfoPage.setMetroStation(metroStation);
   personalInfoPage.setPhoneNumber(phoneNumber);
   personalInfoPage.clickButtonNext();
}
}
