package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage() {
        super();
    }

    private final By closeModalBtn = By.xpath("//div[@class='modal-section-close']");
    private final By searchView = By.xpath("//input[@data-testid='suggestion']");
    private final By product =  By.xpath("//a[@class='product-card']");
    private final By understandBtn = By.xpath("//button[contains(text(),'Anladım')]");
    private final By addToCart = By.xpath("//button[@data-testid='add-to-cart-button']");
    private final By goToCart = By.xpath("//a[@class='link account-basket']");
    private final By cartProduct = By.xpath("//div[@class='merchant-item']");

    private final By productRating = By.xpath("//div[@class='quick-filter productRating']");
    private final By selectedProductRating = By.xpath("//div[@class='quick-filter productRating selected']");
    private final By productName = By.xpath(".//span[@class='product-name']");
    private final By productPrices = By.xpath(".//div[@class='price-section']");
    private final By discountedPrice = By.xpath(".//span[@class='price-value']");
    private final By lowerPrice = By.xpath(".//div[@class='sale-price']");

    Double totalPrices = 0.0;


    public void searchItem(String searchText) {
        click(closeModalBtn);
        waitForVisible(searchView);
        click(searchView);
        setText(searchView, searchText);
        clickEnter(searchView);
    }

    public void clickTopRated() throws InterruptedException {
        click(productRating);
        waitForVisible(selectedProductRating);
        Thread.sleep(2000);
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

   public boolean isCartDisplayed() {
       return waitForVisible(cartProduct).isDisplayed();
   }

    public void getAveragePrices() {
        List<WebElement> productCards = findElements(product);
        List<String> productList = new ArrayList<>();
        int index = 1;

        for (WebElement card : productCards) {
            String name = card.findElement(productName).getText();
            String price = getPriceFromCard(card);

            productList.add("Product " + index + " | Name: " + name + " | Price: " + price);
            index++;
        }

        System.out.println("\n=== ALL PRODUCTS ===");
        productList.forEach(System.out::println);

        double averagePrice = totalPrices / (index-1);
        System.out.println("Average Prices is = " + averagePrice + " total prices =" + totalPrices  + "index =" + index);
    }

   private String getPriceFromCard(WebElement card) {
       By[] pricePaths = {
               productPrices,
               discountedPrice,
               lowerPrice
       };
       for (By path : pricePaths) {
           List<WebElement> found = card.findElements(path);
           if (!found.isEmpty()) {
               String priceText = found.get(0).getText();
               priceText = priceText.replace("TL", "").replace(" ", "");
               priceText = priceText.replace(".", "").replace(",", ".");
               totalPrices = totalPrices + Double.parseDouble(priceText);
               return found.get(0).getText();
           }
       }
       return "NO PRICE";
   }

   }



