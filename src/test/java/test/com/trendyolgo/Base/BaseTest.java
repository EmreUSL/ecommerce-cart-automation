package test.com.trendyolgo.Base;

import com.trendyolgo.Base.ConfigProperties;
import com.trendyolgo.Base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
