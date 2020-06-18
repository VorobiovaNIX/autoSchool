package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductInListening extends AtlasWebElement<ProductInListening> {

    @FindBy(".//span[text()='Add to cart']")
    HtmlElement AddToCartButton();

    @FindBy(".//h5/a")
    HtmlElement nameProduct();

    @FindBy(".//div[1]/span[1]")
    HtmlElement priceProduct();

}
