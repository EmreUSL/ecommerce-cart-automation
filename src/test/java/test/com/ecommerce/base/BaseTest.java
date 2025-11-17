package test.com.ecommerce.base;

import com.ecommerce.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get("https://www.trendyol.com/");
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
