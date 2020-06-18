package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;
    protected Atlas atlas;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        this.atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    public <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
