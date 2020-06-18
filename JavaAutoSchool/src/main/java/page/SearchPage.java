package page;

import element.AddingToCartPopup;
import element.HtmlElement;
import element.ProductInListening;
import element.SortingMenu;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy("//li[contains(@class,'block_product')]")
    ElementsCollection<ProductInListening> listOfProducts();

    @FindBy("//div[@id='layer_cart']")
    AddingToCartPopup layerCart();

    @FindBy("//div[@class ='content_sortPagiBar'][1]")
    SortingMenu topSortingBlock();

    @FindBy(".//span[contains(@class,'lighter')]")
    HtmlElement resultWord();

    @FindBy(".//div[@class='right-block']/*[contains(@class, 'content_price')]/span[not(contains(@class, 'price-percent-reduction'))][last()]")
    ElementsCollection<HtmlElement> priceForSorting();
}
