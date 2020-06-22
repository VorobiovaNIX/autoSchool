package steps;

import element.ProductInCart;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.CartPage;

import static org.hamcrest.CoreMatchers.not;
import static utils.CheckTextOfWebElement.checkText;
import static utils.WebElementIsPresent.isDisplayed;

public class CartPageSteps extends BaseSteps {

    public CartPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that shopping card contains products with correct data")
    public void checkPriceAndNameOnCartPage(int numberOfProduct, String productName, String productPrice) {

        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 1);
        productInCart.productNameInCart().should(checkText(productName));
        productInCart.productPriceInCart().should(checkText(productPrice));

    }

    @Step("Remove Printed Dress")
    public CartPageSteps removeProductOnShoppingCart(int numberOfProduct) {
        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 1);
        productInCart.deleteIcon().click();
        return this;
    }


    @Step("Verify that product has been removed and the second product still displayed on the card")
    public CartPageSteps checkThatProductHasBeenRemoved(int numberOfProduct) {
        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 1);
        productInCart.should(not(isDisplayed()));
        return this;
    }

    @Step("Verify second product is still displayed on the card")
    public void checkThatOtherProductIsDisplayed(int numberOfProduct) {
        ProductInCart productInCart = onCartPage().productsInCart().get(numberOfProduct - 2);
        productInCart.should(isDisplayed());
    }

    /*
. Open home page
2. Search for the "Printed Dress"
3. Select first result
4. Select size M
5. Select quantity 10
6. Click add to card
7. On popup verify that all data match the selected values and total price is correct
8. Continue shopping
9. Search for blouse
10. Select size S
11. Click add to card
12. On popup verify that all data match the selected values and total price is correct
13. Continue shopping
14. Open shopping card

15. Verify that shopping card contains both products with correct data
16. Remove Printed Dress
17. Verify that product has been removed and the second product still displayed on the card

не нужно его дробить на несколько тестов с разніми приоритетами
все в один засунь
     */
    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }
}
