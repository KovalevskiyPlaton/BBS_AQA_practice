package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static enums.TitleNaming.CARTS;
import static enums.ProdutsTitlesNaming.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Epic("Блок корзина товаров")
@Feature("Сравнение наименований товаров положенных в корзину на странице 'Products' с наименованиями товаров, " +
        "которые отображаются на странице 'Your Cart'")

public class BasketTest extends BaseTest {

    @Story("Сравнение коллекций полученных на странице 'Your Cart' и 'Products'")
    @Owner("Kovalevskiy P.V. soulshon@yandex.ru")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("BBS_AQA_practice")
    @Issue("BBS_herokuapp_pract")
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
