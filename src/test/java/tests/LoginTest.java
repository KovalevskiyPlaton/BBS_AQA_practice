package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login();

        //assertEquals(productsPage.getTitle(), "Products",
                //"Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {

        loginPage.open();

        //assertTrue(isTitleVisible);
        //assertEquals(errorText, "Epic sadface: Username is required",
                //"Текст ошибки не соответветсвует ожидаемому");
    }
}
