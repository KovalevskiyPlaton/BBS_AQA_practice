package tests;

import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Standard_user", "secret_sauce", upperCharTextErPassLogin},
                {"standard_user", "Secret_sauce", upperCharTextErPassLogin},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void checkIncorrectLogin(String user, String password, String errorMassage) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMassage, "Текст ошибки не соответветсвует ожидаемому");
    }
}
