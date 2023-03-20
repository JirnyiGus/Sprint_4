package scooter.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    //Локатор кнопки "Заказать"

    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    // Прокрутка до  кнопки "Заказать"
    public void scrollToOrderButton(String textOrderButton) {
        orderButton = By.xpath(".//button[@class='Button_Button__ra12g" + textOrderButton + "']");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(orderButton));
    }

    //Метод нажатия кнопки заказать
    public void clickOrderButton(String textOrderButton) {
        orderButton = By.xpath(".//button[@class='Button_Button__ra12g" + textOrderButton + "']");
        webDriver.findElement(orderButton).click();
    }


    //Локатор "Вопросы о важном"
    private By questionsAboutImportant1 = By.id("accordion__heading-0");
    //Локатор текста вопросов о важном
    private By questionsAboutImportantText = By.xpath(".//div[@id='accordion__panel-0']/p");

    // Прокрутка до блока "Вопросы о важном"
    public void scrollToQuestion() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(questionsAboutImportant1));
    }

    // Метод нажатия "Вопросы о важном"
    public void clickQuestionsAboutImportant1(int number) {
        questionsAboutImportant1 = By.id("accordion__heading-" + number);
        webDriver.findElement(questionsAboutImportant1).click();
    }

    //Метод взятия текста из вопроса о важном
    public String getTextquestionsAboutImportantText(int number) {
        questionsAboutImportantText = By.xpath(".//div[@id='accordion__panel-" + number + "']/p");
        return webDriver.findElement(questionsAboutImportantText).getText();
    }

}
