package layout;

import io.qameta.atlas.webdriver.extension.FindBy;
import element.Header;

public interface WithHeader {

    @FindBy("//header")
    Header header();
}
