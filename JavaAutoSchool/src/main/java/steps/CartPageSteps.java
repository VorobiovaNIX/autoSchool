package steps;

import element.ProductInCart;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.CartPage;

import static utils.CheckTextOfWebElement.checkText;

public class CartPageSteps extends BaseSteps {

    public CartPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check that price and name first product are equal one")
    public void checkPriceAndNameOnCartPage(String productName, String productPrice) {
        ProductInCart firstProductInCart = onCartPage().productsInCart().get(0);
        firstProductInCart.productNameInCart().should(checkText(productName));
        firstProductInCart.productPriceInCart().should(checkText(productPrice));
    }

    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }
}
