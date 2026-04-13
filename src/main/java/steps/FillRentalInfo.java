package steps;

import org.openqa.selenium.WebDriver;

import pages.RentalInfoPage;

public class FillRentalInfo {
    WebDriver driver;
    RentalInfoPage rentalInfoPage;

    public FillRentalInfo(WebDriver driver) {
        this.driver = driver;
        this.rentalInfoPage = new RentalInfoPage(driver);
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
