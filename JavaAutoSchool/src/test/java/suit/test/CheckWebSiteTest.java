package suit.test;

import org.testng.annotations.BeforeTest;

public class CheckWebSiteTest extends BaseTest {

//    WebDriver driver;
//    MainWebSitePageDEPRECATED mainWebSitePage;
//    SearchResultPageDEPRECATED searchResultPage;
//    CartPage cartPage;

    @BeforeTest
    public void startDriver() {
//        driver = getDriver();
//        mainWebSitePage = new MainWebSitePageDEPRECATED(driver);
//        searchResultPage = new SearchResultPageDEPRECATED(driver);
//        cartPage = new CartPage(driver);
    }

    @org.testng.annotations.Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {
//        mainWebSitePage.open();
//        mainWebSitePage.search(searchWord);
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement resultWord = driver.findElement(By.xpath("//span[contains(@class,'lighter')]"));
//        wait.until(ExpectedConditions.visibilityOf(resultWord));
//
//        assertThat(resultWord.getText(),Matchers.equalToIgnoringCase(String.format("\"%s\"", searchWord)));
    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {
//        searchResultPage.filteringByPrice();
//
//        ArrayList<Double> prices = searchResultPage.getListOfPriceOfProducts();
//        assertThat(prices, isSortedAscending());
    }

    @org.testng.annotations.Test(priority = 3)
    public void checkAddingProductToCart() {

//        String productName = searchResultPage.getNameProduct();
//        String productPrice = searchResultPage.getPriceProduct();
//
//        searchResultPage.moveMouseOnProductContainer();
//        searchResultPage.clickOnAddToCart();
//        searchResultPage.openCartPage();
//
//        String productNameInCart = searchResultPage.getProductNameInCart();
//        String productPriceInCart = searchResultPage.getProductPriceInCart();
//
//        assertThat(productName,Matchers.equalTo(productNameInCart));
//        assertThat(productPrice,Matchers.equalTo(productPriceInCart));
    }

}
