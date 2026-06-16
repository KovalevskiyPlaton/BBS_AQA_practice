import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void checkLogin(){
        //1. Открыть браузер
        //2. зайти на сайт

        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com/");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");










    }
}
