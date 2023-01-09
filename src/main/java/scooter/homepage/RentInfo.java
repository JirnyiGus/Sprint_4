package scooter.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentInfo {

    private final WebDriver webDriver;


    public RentInfo(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Локатор поля "Когда привезти самокат"
    private By fieldDateOfShipping = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Локатор для выбора даты
    private By selectDateOfShipping = By.xpath(".//div[text()='9']");

    // Локатор поля "Срок аренды"
    private By fieldRentalPeriod = By.xpath(".//div[@aria-haspopup='listbox']");

    // Локатор для выбора срока аренды

    private By fieldDayRentalPeriod = By.xpath(".//div[(@class='Dropdown-option' and text()='трое суток')]");

    // Локатор для выбора цвета самоката

    private By selectScooterColour = By.xpath(".//label[@for='grey']");

    // Локатор поля "Коментарий для курьера"

    private By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Локатор кнопки "Заказать"

    private By OrderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");


    // Метод нажатия поля "Когда привезти самокат"
    public void enterFieldDateOfShipping() {
        webDriver.findElement(fieldDateOfShipping).click();
    }
    // Метод выбора даты доставки самоката

    public void enterSelectDateOfShipping(String dayNumber) {
        selectDateOfShipping = By.xpath(".//div[text()='" + dayNumber + "']");
        webDriver.findElement(selectDateOfShipping).click();
    }


    // Метод нажатия на поле "Срок аренды"
    public void clickFieldRentalPeriod() {
        webDriver.findElement(fieldRentalPeriod).click();
    }

    // Метод для выбора срока аренды
    public void choiceFieldDayRentalPeriod(String dayCount) {
        fieldDayRentalPeriod = By.xpath(".//div[(@class='Dropdown-option' and text()='" + dayCount + "')]");
        webDriver.findElement(fieldDayRentalPeriod).click();
    }

    // Метод для выбора цвета самоката
    public void clickSelectScooterColour(String scooterColour) {
        selectScooterColour = By.xpath(".//label[@for='" + scooterColour + "']");
        webDriver.findElement(selectScooterColour).click();
    }

    // Метод заполнения поля "Комментарий для курьера"

    public void enterFieldComment(String commentForTheCourier) {
        webDriver.findElement(fieldComment).sendKeys(commentForTheCourier);
    }


    // Метод нажатия кнопки "Заказать"
    public void clickOrderButton() {
        webDriver.findElement(OrderButton).click();
    }
}
