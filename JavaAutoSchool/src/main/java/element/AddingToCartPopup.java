package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddingToCartPopup extends AtlasWebElement<AddingToCartPopup> {

    @FindBy(".//span[contains(text(),'Proceed to checkout')]")
    HtmlElement proceedToCheckoutButton();

    @FindBy(".//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
    HtmlElement continueShopping();

    @FindBy("//span[@id='layer_cart_product_attributes']")
    HtmlElement sizeOfProductOnPopup();

    @FindBy(".//span[@id='layer_cart_product_quantity']")
    HtmlElement quantityOfProductOnPopup();

    @FindBy(".//span[@id='layer_cart_product_price']")
    HtmlElement totalPrice();




}
