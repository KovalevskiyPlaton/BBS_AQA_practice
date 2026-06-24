package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    final String upperCharTextErPassLogin = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required",
                "Текст ошибки не соответветсвует ожидаемому");
    }

    @Test
    public void checkIncorrectLockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.",
                "Текст ошибки не соответветсвует ожидаемому");
    }

    @Test
    public void checkIncorrectIsFirstCharUpperPassword() {
        loginPage.open();
        loginPage.login("standard_user", "Secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), upperCharTextErPassLogin,
                "Текст ошибки не соответветсвует ожидаемому");
    }

    @Test
    public void checkIncorrectIsFirstCharUpperLogin() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), upperCharTextErPassLogin,
                "Текст ошибки не соответветсвует ожидаемому");
    }

    @Test
    public void checkIncorrectEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required",
                "Текст ошибки не соответветсвует ожидаемому");
    }
}
