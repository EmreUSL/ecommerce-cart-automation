package test.com.ecommerce.test;
import com.ecommerce.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.com.ecommerce.base.BaseTest;


public class CardProductTest extends BaseTest {

    private String product;

    @Parameters({"searchProduct"})
    @BeforeMethod
    public void setupParams(String searchProduct) {
        this.product = searchProduct;
    }

    @Test
    public void addProductToCart() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchItem(product);
        searchPage.addToCart();

        Assert.assertTrue(searchPage.isCartDisplayed());
    }

    @Test
    public void calculateAveragePrice() throws InterruptedException {
        SearchPage searchPage = new SearchPage();
        searchPage.searchItem(product);
        searchPage.clickTopRated();
        searchPage.getAveragePrices();

    }

}
