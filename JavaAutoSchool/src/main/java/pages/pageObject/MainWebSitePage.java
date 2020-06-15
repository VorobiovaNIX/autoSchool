package pages.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public class MainWebSitePage extends BasePage {


    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/index.php";

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    public MainWebSitePage(WebDriver driver) {
        super(driver);
    }

    public MainWebSitePage open(){
        driver.get(URL_AUTOPRACTICE);
        driver.manage().window().maximize();
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        return this;
    }

    public SearchResultPage search (String text){
        searchField.sendKeys(text);
        searchField.submit();
        searchField.clear();
        return new SearchResultPage(driver);

    }
}
