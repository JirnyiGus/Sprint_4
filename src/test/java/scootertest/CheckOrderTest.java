package scootertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import scooter.homepage.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class CheckOrderTest {
    WebDriver driver;



    @Before()

    public void setUp() {

        // Драйвер для хрома
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // драйвер для Лисы
       // System.setProperty("webdriver.gecko.driver", "D:\\Download\\WebDriver\\bin\\geckodriver.exe");
        // driver = new FirefoxDriver();

        // Метод с ожиданием
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    // Выбор кнопки "Заказать"
    private final String textOrderButton;
    // Поле "Имя"
    private final String name;
    // Поле "Фамилия"
    private final String lastName;
    // Поле "Адрес"
    private final String address;
    // Выбор станции метро
    private final int choiceMetroStation;
    // Поле "Телефон"
    private final String phone;
    // Поле "Когда привезти самокат"
    private final String dayNumber;
    //Поле "Срок аренды"
    private final String dayCount;
    // Поле "цвет самоката"
    private final String scooterColour;
    //Поле "Комментарий для курьера"
    private final String commentForTheCourier;

    public CheckOrderTest(String textOrderButton, String name, String lastName, String address, int choiceMetroStation, String phone, String dayNumber, String dayCount, String scooterColour, String commentForTheCourier) {
        this.textOrderButton = textOrderButton;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.choiceMetroStation = choiceMetroStation;
        this.phone = phone;
        this.dayNumber = dayNumber;
        this.dayCount = dayCount;
        this.scooterColour = scooterColour;
        this.commentForTheCourier = commentForTheCourier;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {" Button_Middle__1CSJM", "Саша", "Жиркова", "Москва флотская 3", 2, "89057569111", "11", "четверо суток", "grey", "Спасибо"},
                {"", "Глеб", "Каверин", "Москва зеленоградская 17", 1, "89035439111", "10", "трое суток", "black", ""},


        };
    }


    @Test
    public void CheckOrderTest() {
        HomePage homePage = new HomePage(driver);
        CustomerData customerData = new CustomerData(driver);
        RentInfo rentInfo = new RentInfo(driver);
        ConfirmationOfAnOrder confirmationOfAnOrder = new ConfirmationOfAnOrder(driver);
        OrderIsProcessed orderIsProcessed = new OrderIsProcessed(driver);


        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage.scrollToOrderButton(textOrderButton);
        homePage.clickOrderButton(textOrderButton);
        customerData.enterName(name);
        customerData.enterLastName(lastName);
        customerData.enterAddress(address);
        customerData.enterMetroStation();
        customerData.choiceMetroStation(choiceMetroStation);
        customerData.enterFieldPhone(phone);
        customerData.enterNextButton();
        rentInfo.enterFieldDateOfShipping();
        rentInfo.enterSelectDateOfShipping(dayNumber);
        rentInfo.clickFieldRentalPeriod();
        rentInfo.choiceFieldDayRentalPeriod(dayCount);
        rentInfo.clickSelectScooterColour(scooterColour);
        rentInfo.enterFieldComment(commentForTheCourier);
        rentInfo.clickOrderButton();
        confirmationOfAnOrder.clickYesButton();
        boolean isDisplayed = orderIsProcessed.isDisplayed();
        assertTrue(isDisplayed);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

