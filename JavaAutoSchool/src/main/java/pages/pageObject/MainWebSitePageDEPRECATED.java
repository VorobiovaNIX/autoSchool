package pages.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public class MainWebSitePageDEPRECATED extends WebPage {


    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/";

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    public MainWebSitePageDEPRECATED(WebDriver driver) {
        super(driver);
    }

    public MainWebSitePageDEPRECATED open() {
        driver.get(URL_AUTOPRACTICE);
        driver.manage().window().maximize();
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        return this;
    }

    public SearchResultPageDEPRECATED search(String text) {
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);

        searchField.sendKeys(text + Keys.ENTER);
        searchField.clear();
        return new SearchResultPageDEPRECATED(driver);

    }
}
