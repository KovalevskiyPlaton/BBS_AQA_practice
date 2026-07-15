package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    final String upperCharTextErPassLogin = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void checkLogin() {
        System.out.println("LoginTest.checkLogin is running in the Thread: " + Thread.currentThread().getId());

        loginPage
                .open()
                .login(UserFactory.withAdminPremission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Заголовок страницы не соответствует");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withEmtyLogin(), "Epic sadface: Username is required"},
                {UserFactory.withEmtyPassword(), "Epic sadface: Password is required"},
                {UserFactory.withUpCharLogin(), upperCharTextErPassLogin},
                {UserFactory.withUpCharPassword(), upperCharTextErPassLogin},
                {UserFactory.withLockedPremission(), "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void checkIncorrectLogin(User userData, String errorMassage) {
        System.out.println("LoginTest.checkIncorrectLogin is running in the Thread: " + Thread.currentThread().getId());
        loginPage
                .open()
                .login(userData);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMassage, "Текст ошибки не соответветсвует ожидаемому");
    }
}
