package test.com.ecommerce.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
