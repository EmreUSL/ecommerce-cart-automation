package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By searchView = By.xpath("//input[@data-testid='suggestion']");
    private final By product =  By.xpath("//a[@class='product-card']");
    private final By addToCart = By.xpath("//button[@class='add-to-cart-button']");
    private final By goToCart = By.xpath("//p[contains(text(),'Sepetim')]");
    private final By cartProduct = By.xpath("//div[@class='merchant-item']");

    public void searchItem() {
        click(searchView);
        setText(searchView, "Erkek Deri Ceket");
        clickEnter(searchView);
    }

    public void addToCart() {
        waitForVisible(product);
        click(product);
        waitForVisible(addToCart);
        click(addToCart);
        clickEnter(goToCart);
    }




}
