package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    private final WebDriver driver;
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By burgerButton = By.xpath("//button[@id='react-burger-menu-btn']");

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToCart() {
        driver.findElement(cartLink).click();
    }

    public void switchToBurger() {
        driver.findElement(burgerButton).click();
    }
}
