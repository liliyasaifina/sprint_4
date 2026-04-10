
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    //    открываем страницу
     @Parameterized.Parameters
            public static Object[][] setForm(){
        return new Object[][]{
                {"Петр", "Иванов", "Дорожная 2-1", "Черкизовская", "+76568905423"},
                {"Олег", "Семенов", "Гаврилова 8-23", "Бульвар Рокоссовского", "+7567923574"}
        };
            }
    @Test
    public void ButtonSecondTest(){


        // найти кнопку куки, нажать
        mainPage.clickButtonCookie();

//    находим кнопку заказать нижнюю и кликаем

        mainPage.clickButtonSecond();

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
//             страница про аренду
        rentalInfoPage.clickDateField();
        //    в выпадающем календаре выбираем дату
        rentalInfoPage.setDate();
//    находим поле срок аренды, кликаем
        rentalInfoPage.clickRentalPeriodField();
//        в выпадающем списке выбираем срок
        rentalInfoPage.setRentalPeriod();
        //    находим чек-бокс в поле цвет, кликаем
        rentalInfoPage.setColour();
        //            находим поле комментарий, вводим текст
        rentalInfoPage.setComments("Доставка до 13.00");
        //находим кнопку заказать, кликаем
        rentalInfoPage.clickButtonOrder();
        //появляется окно хотите оформить заказ
// находим кнопку да, кликаем
        confirmOrderWindow.clickButtonYes();

        statusWindow.isStatusWindowDisplayed();
    }
}
