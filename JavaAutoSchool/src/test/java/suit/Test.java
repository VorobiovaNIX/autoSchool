package suit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static matchers.SortingCollections.isSortedAscending;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test {

    public static WebDriver driver;


    @BeforeClass
    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mabookair/nixsolutions/autoSchool/JavaAutoSchool/src/test/resources/drivers/chromedriver-3");

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @org.testng.annotations.Test
    public void checkSearching() {

        String searchWord = "SUMMER";
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(searchWord);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click(); // click on the search icon

        WebElement resultWord = driver.findElement(By.xpath("//span[contains(@class,'lighter')]"));

        Assert.assertEquals(String.format("\"%s\"", searchWord), resultWord.getText());
    }

    @org.testng.annotations.Test
    public void checkSortingListOfProduct() {

        driver.findElement(By.xpath("//select[@id='selectProductSort']")).click(); // click on "Sort by" drop-down menu

        driver.findElement(By.xpath("//option[contains(text(),'Price: Highest first')]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        ArrayList<Integer> newList = new ArrayList<>();

        newList.add(1);
        newList.add(5);
        newList.add(2);
        newList.add(3);

        assertThat(newList, isSortedAscending());
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,500)", "");
    }

    @org.testng.annotations.Test
    public void checkAddingProductToCart() {
        /* "Add to cart" button on product  */
        driver.findElement(By.xpath("//li[contains(@class,'block_product')][2]//span[text()='Add to cart']"));

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
