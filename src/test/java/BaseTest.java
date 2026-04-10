import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import steps.FillPersonalInfo;

public class BaseTest {

   public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    WebDriver driver;
    MainPage mainPage;
    PersonalInfoPage personalInfoPage;
    RentalInfoPage rentalInfoPage;
    ConfirmOrderWindow confirmOrderWindow;
    StatusWindow statusWindow;
    FillPersonalInfo setFormFirst;

    @Before
    public void startBrowser(){
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")){
            startBrowserChrome();
        } else if(browser.equals("firefox")) {
            startBrowserFireFox();
        }
        openMainPage();
           }
    public void openMainPage(){
        driver.get(URL);
    }
    public void startBrowserChrome(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        mainPage = new MainPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        rentalInfoPage = new RentalInfoPage(driver);
        confirmOrderWindow = new ConfirmOrderWindow(driver);
        statusWindow = new StatusWindow(driver);
        setFormFirst = new FillPersonalInfo(driver);
    }

    public void startBrowserFireFox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        mainPage = new MainPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        rentalInfoPage = new RentalInfoPage(driver);
        confirmOrderWindow = new ConfirmOrderWindow(driver);
        statusWindow = new StatusWindow(driver);
    }



        @After
        public void tearDown () {
            driver.quit(); //закрываем браузер
        }
    }