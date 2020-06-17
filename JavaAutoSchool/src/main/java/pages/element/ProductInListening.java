package pages.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface ProductInListening extends AtlasWebElement {

    @FindBy(".//span[text()='Add to cart']")
    AtlasWebElement AddToCartButton();

    @FindBy(".//h5/a")
    AtlasWebElement nameProduct();

    @FindBy(".//div[1]/span[1]")
    AtlasWebElement priceProduct();

    @FindBy(".//ul[contains(@class,'product_list grid row')]/li")
    ElementsCollection<WebElement> listOfProducts();
}
