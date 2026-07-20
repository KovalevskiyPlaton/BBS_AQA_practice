package pages;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Epic("Блок оформления заказа")
@Feature("Ввод данных в форму оформления заказа и проверка валидации полученных данных")

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text()='%s']" +
            "//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    public static final String ADD_BUTTON_NAME = "//*[text()='%s']" +
            "//ancestor::div[@class='inventory_item']//child::button";
    private final By title = By.xpath(DATA_TEST_PATTERN.formatted("title"));
    private final By counterColor = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By bucketItem = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By bucketCounterValue = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Проверка заголовка страницы - 'Products'")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Добавление товара по его нименованию: {goodsName} ")
    public ProductsPage addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
        return this;
    }

    @Step("Проверка изменения текста кнопки при добавлении товара")
    public String CheckChangeButtonText(String itemName) {
        By addCart = By.xpath(ADD_BUTTON_NAME.formatted(itemName));
        return driver.findElement(addCart).getText();
    }

    @Step("Отображение иконки корзины")
    public boolean getBucketDisplayed() {
        return driver.findElement(bucketItem).isDisplayed();
    }

    @Step("Добавление товара по индексу")
    public ProductsPage addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
        return this;
    }

    @Step("Проверка счетчика на цвет заднего фона")
    public String checkCounterCssValue() {
        return driver.findElement(counterColor).getCssValue("background-color");
    }

    @Step("Проверка значения счетчика (количество добавленных товаров в корзине)")
    public String getCountItemsBucket() {
        return driver.findElement(bucketCounterValue).getText();
    }
}
