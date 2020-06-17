package pages.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddingToCartPopup extends AtlasWebElement {

    @FindBy(".//span[contains(text(),'Proceed to checkout')]")
    AtlasWebElement proceedToCheckoutButton();


//    @org.openqa.selenium.support.FindBy(xpath = "//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]")
//    private WebElement proceedToCheckoutButton;
}
