package suit.test;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import steps.CartPageSteps;
import steps.MainPageSteps;
import steps.SearchPageSteps;

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
        mainWebSitePage = new MainPageSteps(driver);
        searchResultPage = new SearchPageSteps(driver);
        cartPage = new CartPageSteps(driver);
    }

    @org.testng.annotations.Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {
        mainWebSitePage.open().makeSearch(searchWord).checkThatResultWordAsExpected(searchWord);
    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {
        searchResultPage.sortingByPrice().checkThatListOfProductsIsSortingAsExpected();
    }

    @org.testng.annotations.Test(priority = 3)
    public void checkAddingProductToCart() {

        String productName = searchResultPage.getNameProduct();
        String productPrice = searchResultPage.getPriceProduct();

        searchResultPage.moveMouseOnProductContainer().clickOnAddToCart().openCartPage();

        cartPage.checkPriceAndNameOnCartPage(productName,productPrice);

    }

}
