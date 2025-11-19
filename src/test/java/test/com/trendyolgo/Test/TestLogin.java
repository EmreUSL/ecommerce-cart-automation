package test.com.trendyolgo.Test;

import com.trendyolgo.Base.ConfigProperties;
import com.trendyolgo.Page.HomePage;
import com.trendyolgo.Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.com.trendyolgo.Base.BaseTest;

public class TestLogin extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickGoToLoginPage();
        loginPage.setEmail(ConfigProperties.getProperty("email"));
        loginPage.setPassword(ConfigProperties.getProperty("password"));
        loginPage.clickLogin();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());

    }


}
