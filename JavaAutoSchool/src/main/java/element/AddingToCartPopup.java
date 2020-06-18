package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddingToCartPopup extends AtlasWebElement<AddingToCartPopup> {

    @FindBy(".//span[contains(text(),'Proceed to checkout')]")
    AtlasWebElement proceedToCheckoutButton();

}
