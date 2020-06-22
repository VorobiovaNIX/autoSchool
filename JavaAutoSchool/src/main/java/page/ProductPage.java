package page;

import element.AddingToCartPopup;
import element.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import layout.WithHeader;

public interface ProductPage extends WebPage, WithHeader {

    @FindBy(".//select[@id='group_1']")
    HtmlElement sizeDropDownMenu();

    @FindBy("//select[@id='group_1']/option[text()='{{ text }}']")
    HtmlElement sizeMInDropDownMenu(@Param("text") String text);

    @FindBy(".//input[@id='quantity_wanted']")
    HtmlElement inputQuantity();

    @FindBy(".//span[text()='Add to cart']")
    HtmlElement addToCartButton();

    @FindBy(".//span[@id='our_price_display']")
    HtmlElement pricePerOneProduct();

    @FindBy("//div[@id='layer_cart']")
    AddingToCartPopup layerCart();

}
