package scooter.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerData {
    private final WebDriver webDriver;

    public CustomerData(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Локатор поля "Имя"
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    // Локатор поля "Фамилия"
    private By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // Локатор поля "Адрес"
    private By fieldAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Локатор поля "Станция метро"

    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // Локатор станции метро
    private By metroStation = By.xpath(".//li[(@class='select-search__row' and @data-index='1')]");

    // Локатор поля "Телефон"

    private By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локатор кнопки "Далее"

    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Метод заполнения поля "Имя"
    public void enterName(String name) {
        webDriver.findElement(fieldName).sendKeys(name);
    }


    // Метод заполнения поля "Фамилия"
    public void enterLastName(String lastName) {
        webDriver.findElement(fieldLastName).sendKeys(lastName);
    }

    // Метод заполнения поля "Адрес"
    public void enterAddress(String adress) {
        webDriver.findElement(fieldAdress).sendKeys(adress);
    }

    // Метод нажатия на поле "Станция метро"
    public void enterMetroStation() {
        webDriver.findElement(fieldMetroStation).click();
    }



    // Метод выбора станции метро
    public void choiceMetroStation(int choiceMetroStation) {
        metroStation = By.xpath(".//li[(@class='select-search__row' and @data-index='"+ choiceMetroStation +"')]");
        webDriver.findElement(metroStation).click();
    }


    // Метод заполнения поля "Телефон"
    public void enterFieldPhone(String phone) {
        webDriver.findElement(fieldPhone).sendKeys(phone);
    }

    // Метод нажатия кнопки "Далее"
    public void enterNextButton(){
        webDriver.findElement(nextButton).click();
    }

}
