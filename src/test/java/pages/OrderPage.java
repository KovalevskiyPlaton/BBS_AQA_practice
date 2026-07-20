package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    private final By firstNameInput = By.xpath("//input[@data-test='firstName']");
    private final By lastNameInput = By.xpath("//input[@data-test='lastName']");
    private final By postalCodeInput = By.xpath("//input[@data-test='postalCode']");
    private final By submitButton = By.xpath("//input[@data-test='continue']");
    private final By finishButton = By.xpath("//button[@data-test='finish']");
    private final By ItemTotal = By.xpath("//div[@data-test='subtotal-label']");
    private final By TotalSum = By.xpath("//div[@data-test='total-label']");
    private final By taxSum = By.xpath("//div[@data-test='tax-label']");
    private final By completedTitleText = By.xpath("//span[@data-test='title']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By buttonHome = By.xpath("//button[@data-test='back-to-products']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage open(String url) {
        driver.get(BASE_URL + url);
        return this;
    }

    @Step("Быстрое заполнение полей формы заказа: Имя - {dataFirst}, Фамилия - {dataLast}, Индекс - {dataZipCode}")
    public void fastAllFields(String dataFirst, String dataLast, String dataZipCode) {
        fillInFirstNameField(dataFirst);
        fillInLastNameField(dataLast);
        fillInPostalField(dataZipCode);
    }

    @Step("Заполнение поля формы заказа: Имя - {firstName}")
    public OrderPage fillInFirstNameField(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    @Step("Заполнение поля формы заказа: Фамилия - {lastName}")
    public OrderPage fillInLastNameField(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    @Step("Заполнение поля формы заказа: Индекс - {zipCode}")
    public OrderPage fillInPostalField(String zipCode) {
        driver.findElement(postalCodeInput).sendKeys(zipCode);
        return this;
    }

    @Step("Клик по кнопке 'Continue'")
    public OrderPage submitOrderButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    @Step("Получить текст суммы предварительного заказа")
    public String getTextItemSum() {
        return driver.findElement(ItemTotal).getText();
    }

    @Step("Получить текст итоговый суммы заказа включая налог")
    public String getTotalSum() {
        return driver.findElement(TotalSum).getText();
    }

    @Step("Получить текст суммы налога")
    public String getTaxSum() {
        return driver.findElement(taxSum).getText();
    }

    @Step("Клик по кнопке 'Finish'")
    public OrderPage submitFinishButton() {
        driver.findElement(finishButton).click();
        return this;
    }

    @Step("Получить текст успешного форомления заказа")
    public String getTitleCompletedText() {
        return driver.findElement(completedTitleText).getText();
    }

    @Step("Получить текущий текст ошибки по заполнению полей в адресе доставки")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    @Step("Переход на главную страницу")
    public void goHomePage() {
        driver.findElement(buttonHome).click();
    }
}
