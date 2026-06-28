package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addGoodsToCart("Sauce Labs Onesie");
        productsPage.addGoodsToCart(0);

        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
        assertTrue(productsPage.getBucketDisplayed(), "Иконка корзины не отображается");
        assertEquals(productsPage.checkCounterCssValue(), "rgba(226, 35, 26, 1)", "цвет заднего " +
                "фона не соответсвует макету");
        assertEquals(productsPage.getCountItemsBucket(), "2", "Неверное количество товаров в корзине");
    }
}
