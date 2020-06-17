package pages.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface SortingMenu extends AtlasWebElement {

    @FindBy(".//select[@id='selectProductSort']")
    AtlasWebElement dropDownMenu();

    @FindBy(".//option[contains(text(),'Price: Highest first')]")
    AtlasWebElement option();


}
