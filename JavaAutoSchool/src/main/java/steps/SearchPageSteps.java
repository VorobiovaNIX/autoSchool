package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.SearchPage;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

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
        onSearchPage().topSearchBlock().resultWord().waitUntil(checkText(searchWord));
    }

    @Step("Sorting list of products by 'Price: Highest first' ")
    public SearchPageSteps sortingByPrice() {
        onSearchPage().topSortingBlock().dropDownMenu().click();
        onSearchPage().topSortingBlock().option().click();
        return new SearchPageSteps(driver);
    }

    @Step("Check that sorting results contain exactly «{expectedItems}»")
    public void checkThatListOfProductsIsSortingAsExpected() {
        onSearchPage().listOfProducts().waitUntil(not(empty()))
                .forEach((product -> product.pricesOfProducts()
                        .extract(price -> Double.parseDouble(price.getText().substring(1))).should(isSortedAscending())));
    }

    @Step("Saving name of first product in listening")
    public String getNameProduct() {
        return onSearchPage().listOfProducts().get(0).nameProduct().getText();
    }

    @Step("Saving price of first product in listening")
    public String getPriceProduct() {
        return onSearchPage().listOfProducts().get(0).priceProduct().getText();
    }

    @Step("Move mouse on product container to 'Add to cart' button is displayed ")
    public SearchPageSteps moveMouseOnProductContainer() {
        Actions builder = new Actions(driver);
        builder.moveToElement(onSearchPage().listOfProducts().get(0)).build().perform();
        return new SearchPageSteps(driver);
    }

    @Step("Click on 'Add to cart' button ")
    public SearchPageSteps clickOnAddToCart() {
        onSearchPage().listOfProducts().get(0).AddToCartButton().click();
        Waiters.implicitWait(driver, Waiters.TIME_FIVE, TimeUnit.SECONDS);
        return new SearchPageSteps(driver);
    }

    @Step("Open cart page via 'Proceed to checkout' button on popup")
    public CartPageSteps openCartPage() {
        onSearchPage().layerCart().waitUntil(isDisplayed()).proceedToCheckoutButton().click();
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        return new CartPageSteps(driver);
    }

    private SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }
}
