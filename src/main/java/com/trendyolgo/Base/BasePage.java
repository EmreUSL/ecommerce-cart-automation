package com.trendyolgo.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void setText(By locator, String text) {
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void waitElementVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enter(By locator) {
        findElement(locator).sendKeys(Keys.ENTER);
    }

    public void waitElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isPageDisplayed(By locator) {
       return driver.findElement(locator).isDisplayed();
    }










}
