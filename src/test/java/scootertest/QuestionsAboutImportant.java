package scootertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import scooter.homepage.HomePage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)


public class QuestionsAboutImportant {
    WebDriver driver;

    @Before()

    public void setUp() {

// Драйвер для хрома
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
// драйвер для Лисы
        // System.setProperty("webdriver.gecko.driver", "D:\\Download\\WebDriver\\bin\\geckodriver.exe");
        //driver = new FirefoxDriver();

        // Метод с ожиданием
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    private final int number;
    private final String text;

    public QuestionsAboutImportant(int number, String text) {
        this.number = number;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    @Test
    public void textComparison() {
        HomePage homePage = new HomePage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage.scrollToQuestion();
        homePage.clickQuestionsAboutImportant1(number);

        Assert.assertEquals(text, homePage.getTextquestionsAboutImportantText(number));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
