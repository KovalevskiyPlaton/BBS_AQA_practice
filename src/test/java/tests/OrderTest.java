package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;
import static enums.ProdutsTitlesNaming.*;

import java.util.List;

import static enums.TitleNaming.COMPLETED;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Блок оформления заказа")
@Feature("Ввод данных в форму оформления заказа и проверка валидации полученных данных")

public class OrderTest extends BaseTest {
    public List<String> corrdetData = List.of("Stanislav", "Ishvant", "2341234");
    public List<String> inCorrdZipCodeField = List.of("Valter", "Diesel", "/////");

    @Story("Набор данных для оформления заказа. Полный цикл воспроизведения")
    @Owner("Kovalevskiy P.V. soulshon@yandex.ru")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("BBS_AQA_practice")
    @Issue("BBS_herokuapp_pract")
    @Test
    public void orderCorrectDataTest() {
        loginPage
                .open()
                .login(UserFactory.withAdminPremission());
        List<String> goodsList = List.of(
                TSHIRT.getDisplayName(),
                ONISE.getDisplayName(),
                REDTSHIRT.getDisplayName());
        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }
        orderPage.open("checkout-step-one.html")
                .fillInFirstNameField(corrdetData.get(0))
                .fillInLastNameField(corrdetData.get(1))
                .fillInPostalField(corrdetData.get(2));
        orderPage.submitOrderButton();

        assertEquals(orderPage.getTextItemSum(), "Item total: $39.97", "Неверная предварительная " +
                "сумма товара в чеке ");
        assertEquals(orderPage.getTaxSum(), "Tax: $3.20", "Неверная сумма " +
                "налога");
        assertEquals(orderPage.getTotalSum(), "Total: $43.17", "Неверная итоговая " +
                "сумма товара в чеке ");
        orderPage.submitFinishButton();
        assertEquals(orderPage.getTitleCompletedText(), COMPLETED.getDisplayName(), "Заголовок страницы " +
                "не соответствует ожидаемому");
        orderPage.goHomePage();
    }

    @Story("Набор данных для заполнения формы доставки")
    @Owner("Kovalevskiy P.V. soulshon@yandex.ru")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("BBS_AQA_practice")
    @Issue("BBS_herokuapp_pract")
    @Test
    public void checkOrdersInCorrectZipCodeField() {
        loginPage
                .open()
                .login(UserFactory.withAdminPremission());
        productsPage.addGoodsToCart(1);
        orderPage
                .open("checkout-step-one.html")
                .fillInFirstNameField(inCorrdZipCodeField.get(0))
                .fillInLastNameField(inCorrdZipCodeField.get(1))
                .fillInPostalField(inCorrdZipCodeField.get(2))
                .submitOrderButton()
                .submitFinishButton();
        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("checkout-step-one"), "Произошёл переход на другую страницу");
        assertEquals(orderPage.getTitleCompletedText(), COMPLETED.getDisplayName(), "Заголовок страницы " +
                "не соответствует ожидаемому");
    }

    @DataProvider(name = "checkOrdersInCorrectEmptyFields")
    public Object[][] OrderData() {
        return new Object[][]{
                {"", corrdetData.get(1), corrdetData.get(2), "Error: First Name is required"},
                {corrdetData.get(0), "", corrdetData.get(2), "Error: Last Name is required"},
                {corrdetData.get(0), corrdetData.get(1), "", "Error: Postal Code is required"},
        };
    }

    @Story("Проверка сообщений о вводе некорректных данных")
    @Owner("Kovalevskiy P.V. soulshon@yandex.ru")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("BBS_AQA_practice")
    @Issue("BBS_herokuapp_pract")
    @Test(dataProvider = "checkOrdersInCorrectEmptyFields")
    public void checkOrdersInCorrectEmptyFields
            (String dataFirst, String dataLast, String dataZipCode, String errorMassage) {
        loginPage
                .open()
                .login(UserFactory.withAdminPremission());
        productsPage.addGoodsToCart(1);
        orderPage
                .open("checkout-step-one.html");
        orderPage.fastAllFields(dataFirst, dataLast, dataZipCode);
        orderPage.submitOrderButton();

        assertEquals(orderPage.getErrorMessage(), errorMassage, "Текст ошибки не соответветсвует ожидаемому");
    }
}
