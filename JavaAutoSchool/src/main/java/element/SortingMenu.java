package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface SortingMenu extends AtlasWebElement<SortingMenu> {

    @FindBy(".//select[@id='selectProductSort']")
    HtmlElement dropDownMenu();

    @FindBy(".//option[contains(text(),'Price: Highest first')]")
    HtmlElement option();

}
