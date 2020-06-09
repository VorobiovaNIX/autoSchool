import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsTest {

    public static WebDriver driver;


    @BeforeClass
    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mabookair/nixsolutions/autoSchool/JavaAutoSchool/src/test/resources/chromedriver-3");

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void findElementsByLocators() {

        driver.findElement(By.xpath("//a[@class='login']")); //sign in button

        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")); // search icon

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")); // Dresses catalog in top menu

        driver.findElement(By.id("search_query_top")).sendKeys("SUMMER" + Keys.ENTER); // open page of search result

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")); // 'SEARCH  "SUMMER"' header on search result page

        driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]")).click(); // click on "Sort by" drop-down menu
        driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[5]")).click(); // 'Product Name: Z to A' option

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)", "");

        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")); // icon that convert products to list

        /* "Add to cart" button on product  */
        driver.findElement(By.xpath("//li[contains(@class,'block_produc')][2]//span[text()='Add to cart']"));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
