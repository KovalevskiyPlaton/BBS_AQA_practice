package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static enums.TitleNaming.CARTS;
import static enums.ProdutsTitlesNaming.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BasketTest extends BaseTest {
    @Test
    public void testBasketPage() {
        List<String> goodsList = List.of(
                TSHIRT.getDisplayName(),
                ONISE.getDisplayName(),
                REDTSHIRT.getDisplayName());

        System.out.println("BasketTest is running in the Thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPremission());

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        productsPage.navigationPanel.switchToCart();
        assertEquals(basketPage.getTitle(), CARTS.getDisplayName(), "Заголовк не соответсвует ожидаемому");
        assertTrue(basketPage.getProductsNames().containsAll(goodsList));
        productsPage.navigationPanel.switchToBurger();
    }
}
