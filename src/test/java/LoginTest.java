import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {
    WebDriver driver ;
    @BeforeMethod
    public void setUp(){
        //1. Открыть браузер
        //2. Зайти на сайт
        driver = new FirefoxDriver();
        driver.get("https://saucedemo.com/");
    }



    @Test
    public void checkLogin() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Keys.CONTROL + "A");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Keys.BACK_SPACE);
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String titleName = driver.findElement(By.xpath("//*[@class='title']")).getText();
        assertEquals(titleName, "Products", "Заголовок страницы не соответсвует");


    }

    @AfterMethod
    public void closeBrows(){
        driver.quit();
    }
}
