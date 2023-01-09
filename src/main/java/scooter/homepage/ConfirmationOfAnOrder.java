package scooter.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOfAnOrder {
    private final WebDriver webDriver;

    public ConfirmationOfAnOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // Локатор кнопки "Да"

    private By yesButton = By.xpath(".//button[text()='Да']");

    // Метод нажатия кнопки "Да"
    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }


}





