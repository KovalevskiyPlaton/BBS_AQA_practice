package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        List<String> goodsList = List.of(
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Bike Light",
                "Test.allTheThings() T-Shirt (Red)");

        System.out.println("ProductsTest is running in the Thread: " + Thread.currentThread().getId());
        loginPage
                .open()
                .login(UserFactory.withAdminPremission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Заголовок страницы не соответствует");

        productsPage
                .addGoodsToCart(4);
        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        for (String renameButton : goodsList) {
            assertEquals("Remove", productsPage.CheckChangeButtonText(renameButton),
                    "не соответствеие наименования");
        }

        assertEquals(productsPage.getCountItemsBucket(), "4", "Неверное количество товаров в корзине");
        assertTrue(productsPage.getBucketDisplayed(), "Иконка корзины не отображается");
        assertEquals(productsPage.checkCounterCssValue(), "rgba(226, 35, 26, 1)", "цвет заднего " +
                "фона не соответсвует макету");

        productsPage.navigationPanel.switchToCart();
    }
}
