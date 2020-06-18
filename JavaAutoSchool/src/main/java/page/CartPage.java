package page;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import element.ProductInCart;
import layout.WithHeader;

public interface CartPage extends WebPage, WithHeader {

    @FindBy("//tbody/tr")
    ElementsCollection<ProductInCart> productsInCart();
}
