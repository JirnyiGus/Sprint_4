package scooter.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderIsProcessed {
    private final WebDriver webDriver;

    public OrderIsProcessed(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    // Локатор "Заказ оформлен"
    private By orderIsProcessed = By.xpath(".//div[(@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен')]");


    // Метод проверки, что заказ оформлен
    public boolean isDisplayed() {
        return webDriver.findElement(orderIsProcessed).isDisplayed();

    }
}
