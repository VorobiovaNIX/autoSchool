package steps;

import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebDriver;
import page.MainPage;

import static utils.WebElementIsPresent.isDisplayed;

public class MainPageSteps extends BaseSteps {
    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/";

    public MainPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open web site ")
    public MainPageSteps open() {
        driver.get(URL_AUTOPRACTICE);
        return this;
    }

    @Step("Make search with input string «{input}»")
    public SearchPageSteps makeSearch(String input) {

        AtlasWebElement element = onMainPage().header().searchInput();
        element.waitUntil(isDisplayed()).sendKeys(input);
        element.submit();
        return new SearchPageSteps(driver);
    }

    private MainPage onMainPage() {
        return onPage(MainPage.class);
    }
}
