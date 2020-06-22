package steps;

import element.ProductInCart;
import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import page.CartPage;

import static org.hamcrest.Matchers.*;
import static utils.CheckTextOfWebElement.checkText;
import static utils.WebElementIsPresent.isDisplayed;

public class CartPageSteps extends BaseSteps {

    public CartPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that shopping card contains products with correct data")
    public void checkPriceAndNameOnCartPage(int numberOfProduct, String productName, String productPrice) {

        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 1);

        double expectedTotalPrice = Double.parseDouble(productPrice.substring(1)) * Double
                .parseDouble(productInCart.quantity().getAttribute("value"));

        productInCart.productNameInCart().waitUntil(isDisplayed()).should(checkText(productName));
        productInCart.productPriceInCart().waitUntil(isDisplayed()).should(checkText(Double.toString(expectedTotalPrice)));

    }

    @Step("Get amount of products on shopping cart page")
    public int getAmountOfProductsInCart() {
        return onCartPage().productsInCart().size();
    }

    @Step("Remove Printed Dress")
    public CartPageSteps removeProductOnShoppingCart(int numberOfProduct) {
        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 1);
        productInCart.deleteIcon().click();
        return new CartPageSteps(driver);
    }


    @Step("Verify that product has been removed and the second product still displayed on the card")
    public void checkThatProductHasBeenRemoved(int amountOfProductsBeforeRemoving) {
        onCartPage().productsInCart()
                .waitUntil(not(empty()))
                .should(Matchers.hasSize(amountOfProductsBeforeRemoving-1));
    }

    @Step("Verify second product is still displayed on the card")
    public CartPageSteps checkThatOtherProductIsDisplayed(int numberOfProduct) {
        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 2);
        productInCart.should(isDisplayed());
        return this;
    }

    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }
}
