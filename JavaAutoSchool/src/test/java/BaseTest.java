
import browserFactory.DriverFactory;
import browserFactory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.CartPageSteps;
import steps.MainPageSteps;
import steps.ProductPageSteps;
import steps.SearchPageSteps;

public abstract class BaseTest {

    private static WebDriver driver;
    MainPageSteps mainWebSitePage;
    SearchPageSteps searchResultPage;
    CartPageSteps cartPage;
    ProductPageSteps productPageSteps;

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
    }

    @BeforeMethod
    public void startDriver() {
        mainWebSitePage = new MainPageSteps(driver);
        searchResultPage = new SearchPageSteps(driver);
        cartPage = new CartPageSteps(driver);
        productPageSteps = new ProductPageSteps(driver);
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("All close up activities completed");
        }
    }
}

