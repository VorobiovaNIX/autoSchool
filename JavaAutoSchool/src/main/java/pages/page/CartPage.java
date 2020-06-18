package pages.page;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import pages.element.ProductInCart;
import pages.layout.WithHeader;

public interface CartPage extends WebPage, WithHeader {

    @FindBy("//tbody/tr")
    ElementsCollection<ProductInCart> productsInCart();

}
