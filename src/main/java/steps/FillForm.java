package steps;

import org.openqa.selenium.WebDriver;
import pages.PersonalInfoPage;
import pages.RentalInfoPage;

public class FillForm {
    WebDriver driver;
    PersonalInfoPage personalInfoPage;
    RentalInfoPage rentalInfoPage;

    public FillForm(WebDriver driver) {
        this.driver = driver;
        this.personalInfoPage = new PersonalInfoPage(driver);
        this.rentalInfoPage = new RentalInfoPage(driver);
    }

    public void setPersonalInfo(String firstName, String lastName, String address, String metroStation, String phoneNumber){

   personalInfoPage.setFirstName(firstName);
   personalInfoPage.setLastName(lastName);
   personalInfoPage.setAddress(address);
   personalInfoPage.setMetroStation(metroStation);
   personalInfoPage.setPhoneNumber(phoneNumber);
   personalInfoPage.clickButtonNext();
}
    public void setRentalInfo() {
        rentalInfoPage.clickDateField();
        rentalInfoPage.setDate();
        rentalInfoPage.clickRentalPeriodField();
        rentalInfoPage.setRentalPeriod();
        rentalInfoPage.setColour();
        rentalInfoPage.setComments("Доставка до 13.00");
        rentalInfoPage.clickButtonOrder();
    }
}
