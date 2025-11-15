package com.ecommerce.base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    
    protected void setText(By locator, String value) {
        findElement(locator).clear();
        findElement(locator).sendKeys(value);
    }
    
    protected void click(By locator) {
        findElement(locator).click();
    }
    
    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickEnter (By locator) {
        findElement(locator).sendKeys(Keys.ENTER);
    }
}
