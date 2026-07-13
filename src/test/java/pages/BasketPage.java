package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    private final By pageTitle = By.xpath("//*[@class='title']");
    private final By goodsTitle = By.cssSelector(".inventory_item_name");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(goodsTitle);

        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }
}
