package pages.steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;
    protected Atlas atlas;

    public BaseSteps(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    public <T extends WebPage> T onPage(Class<T> page) {
        //PageFactory.initElements(driver, page);
        return atlas.create(driver, page);
    }
}
