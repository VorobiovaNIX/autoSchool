package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductInCart extends AtlasWebElement<ProductInCart> {

    @FindBy(".//td[@class='cart_description']/p")
    HtmlElement productNameInCart();

    @FindBy(".//td[@data-title='Total']/span[@class='price']")
    HtmlElement productPriceInCart();

    @FindBy(".//i[@class='icon-trash']")
    HtmlElement deleteIcon();
}
