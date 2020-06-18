package pages.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.page.SearchPage;
import utils.Waiters;
import utils.WebElementIsPresent;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchPageSteps extends BaseSteps {

    public SearchPageSteps(WebDriver driver, Atlas atlas) {
        super(driver, atlas);
    }

    @Step("Get text of searching string on Search result page ")
    public WebElement getResultWordOfSearching(){
        return onSearchPage().topSearchBlock().waitUntil(WebElementIsPresent.isDisplayed()).resultWord();
    }

    @Step("Sorting list of products by 'Price: Highest first' ")
    public void sortingByPrice() {
        onSearchPage().topSortingBlock().dropDownMenu().click();
        onSearchPage().topSortingBlock().option().click();
    }

    @Step("Check that sorting results contain exactly expected items ")
    public ArrayList<Double> getListOfPriceOfProducts() {
        ArrayList<Double> prices = new ArrayList<>();
        for (WebElement webElement : onSearchPage().listOfProducts()) {
            double price = Double.parseDouble(webElement.findElement(By.xpath(".//div[@class='right-block']/*" +
                    "[contains(@class, 'content_price')]/span[not(contains(@class, 'price-percent-reduction'))][last()]")).getText().substring(1));
            prices.add(price);
        }
        return prices;
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
    public void moveMouseOnProductContainer() {
        Actions builder = new Actions(driver);
        builder.moveToElement(onSearchPage().listOfProducts().get(0)).build().perform();
    }

    @Step("Click on 'Add to cart' button ")
    public void clickOnAddToCart() {
        onSearchPage().listOfProducts().get(0).AddToCartButton().click();
        Waiters.implicitWait(driver, Waiters.TIME_FIVE, TimeUnit.SECONDS);
    }

    @Step("Open cart page via 'Proceed to checkout' button on popup")
    public CartPageSteps openCartPage() {
        onSearchPage().layerCart().waitUntil(WebElementIsPresent.isDisplayed()).proceedToCheckoutButton().click();
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        return new CartPageSteps(driver, atlas);
    }

    private SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }
}
