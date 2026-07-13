package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasketPage;
import pages.LoginPage;
import pages.OrderPage;
import pages.ProductsPage;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    BasketPage basketPage;
    OrderPage orderPage;


    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\soulshon\\chrome-for-testing\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\soulshon\\chrome-for-testing\\chrome-win64\\chrome.exe");
            options.addArguments("start-maximized");
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\soulshon\\firefox-for-testing\\geckodriver\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Users\\soulshon\\firefox-for-testing\\firefox\\firefox.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
