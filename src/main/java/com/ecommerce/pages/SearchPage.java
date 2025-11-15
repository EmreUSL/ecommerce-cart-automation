package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By closeModalBtn = By.xpath("//div[@class='modal-section-close']");
    private final By searchView = By.xpath("//input[@data-testid='suggestion']");
    private final By product =  By.xpath("//a[@class='product-card']");
    private final By understandBtn = By.xpath("//button[contains(text(),'Anladım')]");
    private final By addToCart = By.xpath("//button[@data-testid='add-to-cart-button']");
    private final By goToCart = By.xpath("//a[@class='link account-basket']");
    private final By cartProduct = By.xpath("//div[@class='merchant-item']");


    public void searchItem() {
        click(closeModalBtn);
        waitForVisible(searchView);
        click(searchView);
        setText(searchView, "Erkek Deri Ceket");
        clickEnter(searchView);
    }

    public void addToCart() {
        waitForVisible(product);
        click(product);
        switchToNewTab();
        scrollWindow(understandBtn);
        scrollElement(addToCart);
        waitForVisible(addToCart);
        click(addToCart);
        scrollElement(goToCart);
        clickEnter(goToCart);
    }

   protected void switchToNewTab() {
        String current = driver.getWindowHandle();

        wait.until(d -> driver.getWindowHandles().size() > 1);

        for (String tab : driver.getWindowHandles()) {
            if(!tab.equals(current)) {
                driver.switchTo().window(tab);
                break;
            }
        }
   }

   protected void scrollWindow(By locator) {
        waitForVisible(locator);
        WebElement element = findElement(locator);
        new Actions(driver)
                .scrollByAmount(0, element.getRect().y + 20)
                .perform();
   }

   protected void scrollElement(By locator) {
       WebElement element = findElement(locator);
       new Actions(driver)
               .scrollToElement(element)
               .perform();
   }






}
