package suit.test;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.pageObject.CartPage;
import pages.pageObject.MainWebSitePage;
import pages.pageObject.SearchResultPage;
import suit.BaseTest;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static suit.BaseTest.getDriver;
import static utils.SortingCollectionsMatcher.isSortedAscending;

public class CheckWebSiteTest extends BaseTest {

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

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultWord = driver.findElement(By.xpath("//span[contains(@class,'lighter')]"));
        wait.until(ExpectedConditions.visibilityOf(resultWord));

        assertThat(resultWord.getText(),Matchers.equalToIgnoringCase(String.format("\"%s\"", searchWord)));
    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {
        searchResultPage.filteringByPrice();

        ArrayList<Double> prices = searchResultPage.getListOfPriceOfProducts();
        assertThat(prices, isSortedAscending());
    }

    @org.testng.annotations.Test(priority = 3)
    public void checkAddingProductToCart() {

        String productName = searchResultPage.getNameProduct();
        String productPrice = searchResultPage.getPriceProduct();

        searchResultPage.moveMouseOnProductContainer();
        searchResultPage.clickOnAddToCart();
        searchResultPage.openCartPage();

        String productNameInCart = searchResultPage.getProductNameInCart();
        String productPriceInCart = searchResultPage.getProductPriceInCart();

        assertThat(productName,Matchers.equalTo(productNameInCart));
        assertThat(productPrice,Matchers.equalTo(productPriceInCart));
    }

}
