package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){

    }
    public void open(){
        driver.get("https://saucedemo.com/");

    }

    protected void login(){
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();


    }
//    assertEquals("Заголовок страницы не соответствует", "Products",
//                 driver.findElement(By.xpath("//*[@class='title']")).getText());


    }
}
