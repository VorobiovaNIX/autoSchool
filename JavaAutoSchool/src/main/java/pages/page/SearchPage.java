package pages.page;

import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import pages.element.AddingToCartPopup;
import pages.element.ProductInListening;
import pages.layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy("//li[contains(@class,'block_product')][1]")
    ProductInListening firstProductContainer();

    @FindBy("//div[@id='layer_cart']")
    AddingToCartPopup layerCart();




}
