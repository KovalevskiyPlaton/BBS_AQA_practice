import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        assertEquals("Заголовок страницы не соответствует", "Products",
                driver.findElement(By.xpath("//*[@class='title']")).getText());
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
        assertEquals("Текст ошибки не соответветсвует ожидаемому",
                "Epic sadface: Username is required", errorText);
    }
}
