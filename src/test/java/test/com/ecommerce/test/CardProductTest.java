package test.com.ecommerce.test;

import com.ecommerce.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import test.com.ecommerce.base.BaseTest;

public class CardProductTest extends BaseTest {

    @Test
    public void addProductToCart() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchItem();
        searchPage.addToCart();

        Assert.assertTrue(searchPage.isCartDisplayed());
    }

    @Test
    public void calculateAveragePrice() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchItem();
        searchPage.clickTopRated();
        searchPage.getAveragePrices();

    }

}
