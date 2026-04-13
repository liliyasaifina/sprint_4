
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.FillPersonalInfo;
import steps.FillRentalInfo;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderButtonFirstTest extends BaseTest {

    private String firstName;
    private String lastName;
    private  String address;
    private String phoneNumber;
    private String metroStation;



    public OrderButtonFirstTest(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
            }
            @Parameterized.Parameters
            public static Object[][] setForm(){
        return new Object[][]{
                {"Петр", "Иванов", "Дорожная 2-1", "Черкизовская", "+76568905423"},
                {"Олег", "Семенов", "Гаврилова 8-23", "Бульвар Рокоссовского", "+7567923574"}
        };
            }
    @Test
    public void ButtonFirstTest() {
        mainPage.clickButtonFirst();
        FillPersonalInfo fillPersonalInfo = new FillPersonalInfo(driver);
        fillPersonalInfo.setPersonalInfo(firstName, lastName, address, metroStation, phoneNumber);
        FillRentalInfo fillRentalInfo = new FillRentalInfo(driver);
        fillRentalInfo.setRentalInfo();
        confirmOrderWindow.clickButtonYes();
        statusWindow.isStatusWindowDisplayed();
        assertTrue("Фактический результат не соответствует ожидаемому", statusWindow.isStatusWindowDisplayed());
    }
}


