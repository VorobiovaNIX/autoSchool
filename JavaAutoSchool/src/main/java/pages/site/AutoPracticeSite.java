package pages.site;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import io.qameta.atlas.webdriver.extension.Query;
import pages.page.CartPage;
import pages.page.MainPage;
import pages.page.SearchPage;

public interface AutoPracticeSite extends WebSite {

    @Page
    MainPage onMainPage();

    @Page(url = "http://automationpractice.com/")
    SearchPage onSearchPage(@Query("q")String value);

    @Page
    CartPage onCartPage();


}
