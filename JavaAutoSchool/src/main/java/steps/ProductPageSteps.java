package steps;

import element.AddingToCartPopup;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import page.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.CheckTextOfWebElement.checkText;

public class ProductPageSteps extends BaseSteps {

    public ProductPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Select size M on product page")
    public ProductPageSteps selectSizeOfProduct(String size) {
        onProductPage().sizeDropDownMenu().click();
        onProductPage().sizeMInDropDownMenu(size).click();
        return this;
    }

    @Step("Select quantity of product ")
    public ProductPageSteps selectQuantityOfProduct(String quantity) {
        AtlasWebElement input = onProductPage().inputQuantity();
        input.clear();
        input.sendKeys(quantity);
        return this;
    }

    @Step("Click on 'Add to cart' button ")
    public ProductPageSteps clickOnAddToCart() {
        onProductPage().addToCartButton().click();
        return this;
    }

    @Step("On popup verify that all data match the selected values and total price is correct")
    public void checkThatSizeAndTotalPriceAreCorrectOnPopup(String quantity, String size) {

        AddingToCartPopup productPopup = onProductPage().layerCart();
        productPopup.quantityOfProductOnPopup().should(checkText(quantity));
        productPopup.sizeOfProductOnPopup().should(checkText(size));

        double expectedTotalPrice = Double.parseDouble(quantity) * Double.parseDouble(onProductPage()
                .pricePerOneProduct().getText().substring(1));

        double actualTotalPrice = Double.parseDouble(productPopup.totalPrice().getText().substring(1));

        assertThat(actualTotalPrice, Matchers.equalTo(expectedTotalPrice));

        onProductPage().layerCart().continueShopping().click();
    }

    @Step("Open Cart page")
    public CartPageSteps openShoppingCard() {
        onProductPage().header().cart().click();
        return new CartPageSteps(driver);
    }

    private ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

}
