package pages.browserFactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver getManager(DriverType type) {
        switch (type) {
            case CHROME:
                return new ChromeDriverManager().getDriver();
            case FIREFOX:
                return new FirefoxDriverManager().getDriver();
            case SAFARI:
                return new SafariDriverManager().getDriver();
            default:
                return new ChromeDriverManager().getDriver();
        }
    }
}
