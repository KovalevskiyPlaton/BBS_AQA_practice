package pages;

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

    public void fastAllFields(String dataFirst, String dataLast, String dataZipCode){
        fillInFirstNameField(dataFirst);
        fillInLastNameField(dataLast);
        fillInPostalField(dataZipCode);
    }

    public OrderPage fillInFirstNameField(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public OrderPage fillInLastNameField(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public OrderPage fillInPostalField(String zipCode) {
        driver.findElement(postalCodeInput).sendKeys(zipCode);
        return this;
    }

    public OrderPage submitOrderButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    public String getTextItemSum() {
        return driver.findElement(ItemTotal).getText();
    }

    public String getTotalSum() {
        return driver.findElement(TotalSum).getText();
    }

    public String getTaxSum() {
        return driver.findElement(taxSum).getText();
    }

    public OrderPage submitFinishButton() {
        driver.findElement(finishButton).click();
        return this;
    }

    public String getTitleCompletedText() {
        return driver.findElement(completedTitleText).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void goHomePage(){
        driver.findElement(buttonHome).click();
    }
}
