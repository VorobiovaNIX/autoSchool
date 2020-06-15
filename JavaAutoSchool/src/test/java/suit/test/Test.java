package suit.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.pageObject.CartPage;
import pages.pageObject.MainWebSitePage;
import pages.pageObject.SearchResultPage;
import suit.BaseTest;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.SortingCollectionsMatcher.isSortedAscending;

public class Test extends BaseTest {

    WebDriver driver;
    MainWebSitePage mainWebSitePage;
    SearchResultPage searchResultPage;
    CartPage cartPage;


    @BeforeTest
    public void startDriver() {
        driver = getDriver();
        mainWebSitePage = new MainWebSitePage(driver);
        searchResultPage = new SearchResultPage(driver);
        cartPage = new CartPage(driver);
    }

    @org.testng.annotations.Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {
        mainWebSitePage.open();
        mainWebSitePage.search(searchWord);
        WebElement resultWord = driver.findElement(By.xpath("//span[contains(@class,'lighter')]"));

        Assert.assertEquals(String.format("\"%s\"", searchWord).toUpperCase(), resultWord.getText());
    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {
        searchResultPage.filteringByPrice();

        ArrayList<Double> prices = searchResultPage.getListOfPriceOfProducts();
        assertThat(prices, isSortedAscending());
    }

    @org.testng.annotations.Test(priority = 3)
    public void checkAddingProductToCart() {

        String productName = driver.findElement(By.xpath("//ul[contains(@class,'product_list grid row')]/li[1]//h5/a")).getText();
        String productPrice = driver.findElement(By.xpath("//ul[contains(@class,'product_list grid row')]/li[1]//div[1]/span[1]")).getText();

        searchResultPage.moveMouseOnProductContainer();
        searchResultPage.clickOnAddToCart();

        searchResultPage.openCartPage();

        String productNameInCart = driver.findElement(By.xpath("//td[@class='cart_description']/p")).getText();
        String productPriceInCart = driver.findElement(By.xpath("//td[@data-title='Total']/span[@class='price']")).getText();


        Assert.assertEquals(productName, productNameInCart, "Name of product from list and name of product in cart aren't equals.");
        Assert.assertEquals(productPrice, productPriceInCart, "Price of product from list and price of product in cart aren't equals.");
    }

}
