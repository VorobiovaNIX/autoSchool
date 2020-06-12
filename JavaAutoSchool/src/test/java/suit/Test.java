package suit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static matchers.SortingCollections.isSortedAscending;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test {

    public static WebDriver driver;

    @DataProvider
    public static Object[][] dataForSearching() {
        return new Object[][]{
                new Object[]{"Dress"},
                new Object[]{"t-shirt"},
                new Object[]{"Summer"}
        };
    }

    @BeforeClass
    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mabookair/nixsolutions/autoSchool/JavaAutoSchool/src/test/resources/drivers/chromedriver-3");

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @org.testng.annotations.Test(priority = 1, dataProvider = "dataForSearching")
    public void checkSearching(String searchWord) {

        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(searchWord);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click(); // click on the search icon
        driver.findElement(By.xpath("//input[@id='search_query_top']")).clear(); // clear search field

        WebElement resultWord = driver.findElement(By.xpath("//span[contains(@class,'lighter')]"));

        Assert.assertEquals(String.format("\"%s\"", searchWord).toUpperCase(), resultWord.getText());

    }

    @org.testng.annotations.Test(priority = 2)
    public void checkSortingListOfProduct() {

        driver.findElement(By.xpath("//select[@id='selectProductSort']")).click(); // click on "Sort by" drop-down menu

        driver.findElement(By.xpath("//option[contains(text(),'Price: Highest first')]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> listOfProduct = driver.findElements(By.xpath("//ul[contains(@class,'product_list grid row')]/li"));

        ////div/div[2]/div[1]/span[2]    - старая цена
        //  //div/div[2]/div[1]/span[1] - актуальная цена
        ArrayList<Double> prices = new ArrayList<>();
        for (WebElement webElement : listOfProduct) {
            double price = Double.parseDouble(webElement
                    .findElement(By.xpath(".//div[@class='right-block']/*[contains(@class, 'content_price') and " +
                            "not(*[contains(@class, 'old-price')])] | .//div[@class='right-block']/*[contains(@class, " +
                            "'content_price') and (*[contains(@class, 'old-price')])]/span[2]")).getText().substring(1));
            prices.add(price);
        }

        assertThat(prices, isSortedAscending());

    }

    @org.testng.annotations.Test(priority = 3)
    public void checkAddingProductToCart() {
        String productName = driver.findElement(By.xpath("//ul[contains(@class,'product_list grid row')]/li[1]//h5/a")).getText();
        System.out.println(productName);
        String productPrice = driver.findElement(By.xpath("//ul[contains(@class,'product_list grid row')]/li[1]//div[1]/span[1]")).getText();
        System.out.println(productPrice);

        /* click on "Add to cart" button on first product  */
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='center_column']/ul/li[1]/div"))).build().perform();
        driver.findElement(By.xpath("//li[contains(@class,'block_product')][1]//span[text()='Add to cart']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='layer_cart']/div[1]/div[1]/span")).click(); // close pop-up

        driver.findElement(By.xpath("//div[@class='shopping_cart']/a")).click(); // open Cart page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");


        String productNameInCart = driver.findElement(By.xpath("//td[@class='cart_description']/p")).getText();
        System.out.println(productNameInCart);

        String productPriceInCart = driver.findElement(By.xpath("//td[@data-title='Total']/span[@class='price']")).getText();
        System.out.println(productPriceInCart);


        Assert.assertEquals(productName, productNameInCart, "Name of product from list and name of product in cart aren't equals.");
        Assert.assertEquals(productPrice, productPriceInCart, "Price of product from list and price of product in cart aren't equals.");
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
