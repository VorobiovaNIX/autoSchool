package suit.test;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import pages.steps.CartPageSteps;
import pages.steps.MainPageSteps;
import pages.steps.SearchPageSteps;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.CheckTextOfWebElement.checkText;
import static utils.SortingCollectionsMatcher.isSortedAscending;

public class CheckWebSiteTest extends BaseTest {

    WebDriver driver;
    Atlas atlas;
    MainPageSteps mainWebSitePage;
    SearchPageSteps searchResultPage;
    CartPageSteps cartPage;

    @BeforeTest
    public void startDriver() {
        driver = getDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver));
        mainWebSitePage = new MainPageSteps(driver,atlas);
        searchResultPage = new SearchPageSteps(driver,atlas);
        cartPage = new CartPageSteps(driver,atlas);
    }

    @org.testng.annotations.Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {
        mainWebSitePage.open();
        mainWebSitePage.makeSearch(searchWord);

        assertThat(searchResultPage.getResultWordOfSearching(), checkText(searchWord));
    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {
        searchResultPage.sortingByPrice();

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

        String productNameInCart = cartPage.getProductNameInCart();
        String productPriceInCart = cartPage.getProductPriceInCart();

        assertThat(productName,Matchers.equalTo(productNameInCart));
        assertThat(productPrice,Matchers.equalTo(productPriceInCart));
    }

}
