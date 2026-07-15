package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public ProductsPage addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
        return this;
    }

    public String CheckChangeButtonText(String itemName) {
        By addCart = By.xpath(ADD_BUTTON_NAME.formatted(itemName));
        return driver.findElement(addCart).getText();
    }

    public boolean getBucketDisplayed() {
        return driver.findElement(bucketItem).isDisplayed();
    }

    public ProductsPage addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
        return this;
    }

    public String checkCounterCssValue() {
        return driver.findElement(counterColor).getCssValue("background-color");
    }

    public String getCountItemsBucket() {
        return driver.findElement(bucketCounterValue).getText();
    }
}
