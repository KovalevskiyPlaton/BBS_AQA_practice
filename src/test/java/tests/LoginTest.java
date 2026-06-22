package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        assertEquals(driver.findElement(By.xpath("//*[@class='title']")).getText(), "Products",
                "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean isTitleVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(isTitleVisible);
        assertEquals(errorText, "Epic sadface: Username is required",
                "Текст ошибки не соответветсвует ожидаемому");
    }
}
