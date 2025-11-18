package com.trendyolgo.Page;

import com.trendyolgo.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By goToLoginPage = By.xpath("//a[contains(text(), 'Giriş Yap')]");
    private final By emailArea = By.id("username");
    private final By passwordArea = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public void clickGoToLoginPage() {
        click(goToLoginPage);
        waitElementVisibility(emailArea);
    }

    public void setEmail(String email) {
        setText(emailArea, email);
    }

    public void setPassword(String password) {
        setText(passwordArea, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

}
