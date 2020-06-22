package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.SearchPage;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static utils.CheckTextOfWebElement.checkText;
import static utils.SortingCollectionsMatcher.isSortedAscending;
import static utils.WebElementIsPresent.isDisplayed;

public class SearchPageSteps extends BaseSteps {

    public SearchPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check {searchWord} of searching string on Search result page ")
    public void checkThatResultWordAsExpected(String searchWord) {
        onSearchPage().resultWord().should(checkText(searchWord));
    }

    @Step("Sorting list of products by 'Price: Highest first' ")
    public SearchPageSteps sortingByPrice() {
        onSearchPage().topSortingBlock().dropDownMenu().click();
        onSearchPage().topSortingBlock().option().click();
        return this;
    }

    @Step("Check that sorting results contain exactly «{expectedItems}»")
    public void checkThatListOfProductsIsSortingAsExpected() {
        onSearchPage().priceForSorting()
                .waitUntil(not(empty()))
                .extract(price -> Double.parseDouble(price.getText()
                        .substring(1))).should(isSortedAscending());
    }

    @Step("Saving name of first product in listening")
    public String getNameProduct(int numberOfProduct) {
        return onSearchPage().listOfProducts().get(numberOfProduct - 1).nameProduct().getText();
    }

    @Step("Saving price of first product in listening")
    public String getPriceProduct(int numberOfProduct) {
        return onSearchPage().listOfProducts().get(numberOfProduct - 1).priceProduct().getText();
    }

    @Step("Move mouse on product container to 'Add to cart' button is displayed ")
    public SearchPageSteps moveMouseOnProductContainer() {
        Actions builder = new Actions(driver);
        builder.moveToElement(onSearchPage().listOfProducts().get(0)).build().perform();
        return this;
    }

    @Step("Click on 'Add to cart' button ")
    public SearchPageSteps clickOnAddToCart() {
        onSearchPage().listOfProducts().get(0).waitUntil(not(empty())).AddToCartButton().click();
        return this;
    }

    @Step("Open cart page via 'Proceed to checkout' button on popup")
    public CartPageSteps openCartPage() {
        onSearchPage().layerCart().proceedToCheckoutButton().waitUntil(isDisplayed()).click();
        return new CartPageSteps(driver);
    }

    @Step("Open product page via click on product container")
    public ProductPageSteps openProductPage() {
        onSearchPage().listOfProducts().get(0).waitUntil(not(empty())).click();
        return new ProductPageSteps(driver);
    }

    private SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }
}
