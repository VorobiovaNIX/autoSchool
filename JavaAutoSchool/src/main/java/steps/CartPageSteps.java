package steps;

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
        onCartPage().productsInCart().get(0).productNameInCart().should(checkText(productName));
        onCartPage().productsInCart().get(0).productPriceInCart().should(checkText(productPrice));
    }

    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }
}
