package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductInListening extends AtlasWebElement<ProductInListening> {

    @FindBy(".//span[text()='Add to cart']")
    HtmlElement AddToCartButton();

    @FindBy(".//h5/a")
    HtmlElement nameProduct();

    @FindBy(".//div[1]/span[1]")
    HtmlElement priceProduct();

    @FindBy(".//span[contains(@class,'lighter')]")
    HtmlElement resultWord();

    @FindBy(".//div[@class='right-block']/*[contains(@class, 'content_price')]/span[not(contains(@class, 'price-percent-reduction'))][last()]")
    ElementsCollection<HtmlElement> pricesOfProducts();
   // HtmlElement pricesOfProducts();

}
