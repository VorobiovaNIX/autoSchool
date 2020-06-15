package suit;

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
        if (browser.equals("Firefox")) {
            driver = DriverFactory.getManager(DriverType.FIREFOX);
        } else if (browser.equals("Chrome")) {
            driver = DriverFactory.getManager(DriverType.CHROME);
        } else if (browser.equals("Safari")) {
            driver = DriverFactory.getManager(DriverType.SAFARI);
        } else {
            System.out.println("Invalid browser " + browser);
        }

        driver.manage().window().maximize();
        Waiters.implicitWait(driver, Waiters.TIME_FIVE, TimeUnit.SECONDS);
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
        System.out.println("All close up activities completed");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

