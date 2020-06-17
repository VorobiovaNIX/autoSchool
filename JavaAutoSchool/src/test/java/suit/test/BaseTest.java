package suit.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.browserFactory.DriverFactory;
import pages.browserFactory.DriverType;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver driver;

    @DataProvider
    public static Object[][] dataForSearching() {
        return new Object[][]{
                new Object[]{"Dress"},
                new Object[]{"t-shirt"},
                new Object[]{"Summer"}
        };
    }

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        switch (browser) {
            case "Firefox":
                driver = DriverFactory.getManager(DriverType.FIREFOX);
                break;
            case "Chrome":
                driver = DriverFactory.getManager(DriverType.CHROME);
                break;
            case "Safari":
                driver = DriverFactory.getManager(DriverType.SAFARI);
                break;
            default:
                System.out.println("Invalid browser " + browser);
                break;
        }

        driver.manage().window().maximize();
        Waiters.implicitWait(driver, Waiters.TIME_FIVE, TimeUnit.SECONDS);
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("All close up activities completed");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

