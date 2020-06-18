package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

import static utils.WebElementIsPresent.isDisplayed;

public class MainPageSteps extends BaseSteps {
    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/";

    public MainPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open web site ")
    public MainPageSteps open() {
        driver.get(URL_AUTOPRACTICE);
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        return this;
    }

    @Step("Make search with input string «{input}»")
    public SearchPageSteps makeSearch(String input) {

//        AtlasWebElement element = onMainPage().header().searchInput().waitUntil(isDisplayed());
//        element.sendKeys(input);
//        element.submit();
        onMainPage().header().searchInput().waitUntil(isDisplayed()).sendKeys(input);
        onMainPage().header().searchInput().submit();
        onMainPage().header().searchInput().clear();

        return new SearchPageSteps(driver);
    }

    private MainPage onMainPage() {
        return onPage(MainPage.class);
    }
}
