package pages.layout;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.element.Header;

public interface WithHeader {

    @FindBy("//header")
    Header header();
}
