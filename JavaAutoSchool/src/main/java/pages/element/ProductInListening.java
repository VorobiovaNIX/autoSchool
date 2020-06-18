package pages.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductInListening extends AtlasWebElement<ProductInListening> {

    @FindBy(".//span[text()='Add to cart']")
    AtlasWebElement AddToCartButton();

    @FindBy(".//h5/a")
    AtlasWebElement nameProduct();

    @FindBy(".//div[1]/span[1]")
    AtlasWebElement priceProduct();

    @FindBy(".//span[contains(@class,'lighter')]")
    AtlasWebElement resultWord();

}
