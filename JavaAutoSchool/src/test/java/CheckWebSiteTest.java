
import org.testng.annotations.Test;
import steps.SearchPageSteps;

public class CheckWebSiteTest extends BaseTest {

    @Test(priority = 1, dataProvider = "dataForSearching", enabled = false)
    public void checkSearching(String searchWord) {
        mainWebSitePage.open().makeSearch(searchWord).checkThatResultWordAsExpected(searchWord);
    }

    @Test(priority = 2, enabled = false)
    public void checkSortingListOfProduct() {
        searchResultPage.sortingByPrice().checkThatListOfProductsIsSortingAsExpected();
    }

    @Test(priority = 3, enabled = false)
    public void checkAddingProductToCart() {
        String productName = searchResultPage.getNameProduct(1);
        String productPrice = searchResultPage.getPriceProduct(1);

        searchResultPage.moveMouseOnProductContainer().clickOnAddToCart().openCartPage();

        cartPage.checkPriceAndNameOnCartPage(1, productName, productPrice);
    }

    @Test(priority = 4)
    public void checkThatAllDataMatchOnPopup() {
        mainWebSitePage.open().makeSearch("Printed dress").openProductPage();

        productPageSteps.selectSizeOfProduct("M")
                .selectQuantityOfProduct("10")
                .clickOnAddToCart()
                .checkThatSizeAndTotalPriceAreCorrectOnPopup("10", "M");

        mainWebSitePage.open().makeSearch("blouse").openProductPage();

        productPageSteps.selectSizeOfProduct("S")
                .clickOnAddToCart()
                .checkThatSizeAndTotalPriceAreCorrectOnPopup("1", "S");

        productPageSteps.openShoppingCard();

        SearchPageSteps firstProduct = mainWebSitePage.open().makeSearch("Printed dress");
        String firstProductName = firstProduct.getNameProduct(1);
        String firstProductPrice = firstProduct.getPriceProduct(1);


        SearchPageSteps secondProduct = mainWebSitePage.open().makeSearch("blouse");
        String secondProductName = secondProduct.getNameProduct(1);
        String secondProductPrice = secondProduct.getPriceProduct(1);

        cartPage.checkPriceAndNameOnCartPage(1, firstProductName, firstProductPrice);

        cartPage.checkPriceAndNameOnCartPage(2, secondProductName, secondProductPrice);

//        cartPage.removeProductOnShoppingCart(1)
//                .checkThatProductHasBeenRemoved(1)
//                .checkThatOtherProductIsDisplayed(2);


    }

}

