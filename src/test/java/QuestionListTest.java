
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class QuestionListTest extends BaseTest{

    private int index;
    private String expectedQuestion;
    private String expectedAnswer;


    public QuestionListTest(int index, String expectedQuestion, String expectedAnswer) {
        this.index = index;
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
    }
    @Parameterized.Parameters
    public static Object[][] getExpected() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }
    @Test
    public void questionCheck() {
       mainPage.clickButtonCookie();
        String questionLocator = ".accordion__button";
        String answerLocator = "[id^='accordion__panel-'] > p";
        List<WebElement> questions = driver.findElements(By.cssSelector(questionLocator));
        List<WebElement> answers = driver.findElements(By.cssSelector(answerLocator));
        questions.get(index).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String questionText = questions.get(index).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(answerLocator)));
        String answerText = answers.get(index).getText();
                assertTrue("Вопрос или ответ не соответствуют ожидаемым",  questionText.equals(expectedQuestion) &&
                answerText.equals(expectedAnswer));
    }
}


