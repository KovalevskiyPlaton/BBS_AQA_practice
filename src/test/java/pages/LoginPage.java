package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginInput = By.xpath("//input[@placeholder='Username']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By submitButton = By.xpath("//input[@placeholder='Password']");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://saucedemo.com/");
    }

    public void login() {
        driver.findElement(loginInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(submitButton).click();
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//*[@class='title']")).getText();
    }
}

