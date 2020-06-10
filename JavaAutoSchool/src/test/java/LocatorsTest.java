import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

        driver.findElement(By.xpath("//button[@name='submit_search']")); // search icon

        /*  Dresses catalog in top menu OR //div[@id='block_top_menu']/ul/li[2]/a[text()='Dresses']  */
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"));


        /*open the page of search result */
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("SUMMER" + Keys.ENTER);

        /* 'SEARCH  "SUMMER"' header on search result page OR //h1[@class='page-heading  product-listing']    */
        driver.findElement(By.xpath("//h1[contains(@class,'product-listing')]"));

        driver.findElement(By.xpath("//select[@id='selectProductSort']")).click(); // click on "Sort by" drop-down menu

        /* 'Product Name: Z to A' option OR //select[@id='selectProductSort']/option[5] */
        driver.findElement(By.xpath("//option[contains(text(),'Product Name: Z to A')]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)", "");

        driver.findElement(By.xpath("//li[@id='list']")); // icon that convert grid of products to list of products


        /* "Add to cart" button on product  */
        driver.findElement(By.xpath("//li[contains(@class,'block_product')][2]//span[text()='Add to cart']"));


    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
