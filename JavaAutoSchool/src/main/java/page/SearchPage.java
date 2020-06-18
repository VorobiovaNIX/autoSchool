package page;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import element.AddingToCartPopup;
import element.ProductInListening;
import element.SortingMenu;
import layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy("//li[contains(@class,'block_product')][1]")
    ElementsCollection<ProductInListening> listOfProducts();

    @FindBy("//div[@id='layer_cart']")
    AddingToCartPopup layerCart();

    @FindBy("//div[@class ='content_sortPagiBar'][1]")
    SortingMenu topSortingBlock();

    @FindBy("//h1[contains(@class,'product-listing')]")
    ProductInListening topSearchBlock();
}
