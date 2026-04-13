
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.FillPersonalInfo;
import steps.FillRentalInfo;

import static org.junit.Assert.assertTrue;
@RunWith(Parameterized.class)
public class OrderButtonSecondTest extends BaseTest {


    private String firstName;
    private String lastName;
    private  String address;
    private String phoneNumber;
    private String metroStation;


    public OrderButtonSecondTest(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
    }

     @Parameterized.Parameters
            public static Object[][] setForm(){
        return new Object[][]{
                {"Петр", "Иванов", "Дорожная 2-1", "Черкизовская", "+76568905423"},
                {"Олег", "Семенов", "Гаврилова 8-23", "Бульвар Рокоссовского", "+7567923574"}
        };
            }
    @Test
    public void ButtonSecondTest(){

        mainPage.clickButtonCookie();
        mainPage.clickButtonSecond();
        FillPersonalInfo fillPersonalInfo = new FillPersonalInfo(driver);
        fillPersonalInfo.setPersonalInfo(firstName, lastName, address, metroStation, phoneNumber);
        FillRentalInfo fillRentalInfo = new FillRentalInfo(driver);
        fillRentalInfo.setRentalInfo();
        confirmOrderWindow.clickButtonYes();
        statusWindow.isStatusWindowDisplayed();
        assertTrue("Фактический результат не соответствует ожидаемому", statusWindow.isStatusWindowDisplayed());
    }
}
