package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.CartPage;

public class CartPageSteps extends BaseSteps{

    public CartPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Get name of first product on cart page")
    public String getProductNameInCart() {
        return onCartPage().productsInCart().get(0).productNameInCart().getText();
    }

    @Step("Get price of first product on cart page")
    public String getProductPriceInCart() {
        return onCartPage().productsInCart().get(0).productPriceInCart().getText();
    }

    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }
}
