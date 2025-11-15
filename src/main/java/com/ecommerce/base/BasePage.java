package com.ecommerce.base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

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
