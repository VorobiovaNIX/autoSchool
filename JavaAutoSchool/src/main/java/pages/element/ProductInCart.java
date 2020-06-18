package pages.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductInCart extends AtlasWebElement<ProductInCart> {

    @FindBy(".//td[@class='cart_description']/p")
    AtlasWebElement productNameInCart();

    @FindBy(".//td[@data-title='Total']/span[@class='price']")
    AtlasWebElement productPriceInCart();
}
