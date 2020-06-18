package suit.test;

import org.testng.annotations.Test;

public class CheckWebSiteTest extends BaseTest {

    @Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {
        mainWebSitePage.open().makeSearch(searchWord).checkThatResultWordAsExpected(searchWord);
    }

    @Test(priority = 2)
    public void checkSortingListOfProduct() {
        searchResultPage.sortingByPrice().checkThatListOfProductsIsSortingAsExpected();
    }

    @Test(priority = 3)
    public void checkAddingProductToCart() {

        String productName = searchResultPage.getNameProduct();
        String productPrice = searchResultPage.getPriceProduct();

        searchResultPage.moveMouseOnProductContainer().clickOnAddToCart().openCartPage();

        cartPage.checkPriceAndNameOnCartPage(productName,productPrice);
    }

}
