package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By loginInput = By.xpath(DATA_TEST_PATTERN.formatted("username"));
    private final By passwordInput = By.xpath(DATA_TEST_PATTERN.formatted("password"));
    private final By submitButton = By.xpath(DATA_TEST_PATTERN.formatted("login-button"));
    private final By error = By.xpath(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage login(User user) {
        fillInLoginField(user.getName());
        fillInPasswordField(user.getPassword());
        driver.findElement(submitButton).click();
        return this;
    }

    public void fillInLoginField(String login){
        driver.findElement(loginInput).sendKeys(login);
    }

    public void fillInPasswordField(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(error).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }
}
