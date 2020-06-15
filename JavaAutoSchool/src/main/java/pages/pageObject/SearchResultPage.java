package pages.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.Waiters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.Waiters.TIME_FIVE;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='selectProductSort']")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//option[contains(text(),'Price: Highest first')]")
    private WebElement option;

    @FindBy(xpath = "//div[@id='center_column']//li[1]/div")
    private WebElement firstProductContainer;

    @FindBy(xpath = "//li[contains(@class,'block_product')][1]//span[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    public void filteringByPrice() {
        dropDownMenu.click(); // click on "Sort by" drop-down menu
        option.click();
        Waiters.implicitWait(driver, TIME_FIVE, TimeUnit.SECONDS);
    }

    List<WebElement> listOfProduct = driver.findElements(By.xpath("//ul[contains(@class,'product_list grid row')]/li"));

    public ArrayList<Double> getListOfPriceOfProducts() {

        ArrayList<Double> prices = new ArrayList<>();
        for (WebElement webElement : listOfProduct) {
            double price = Double.parseDouble(webElement.findElement(By.xpath(".//div[@class='right-block']/*" +
                    "[contains(@class, 'content_price')]/span[not(contains(@class, 'price-percent-reduction'))][last()]")).getText().substring(1));
            prices.add(price);
        }
        return prices;
    }

    public void moveMouseOnProductContainer() {
        Actions builder = new Actions(driver);
        builder.moveToElement(firstProductContainer).build().perform();
    }

    public void clickOnAddToCart() {
        addToCartButton.click();
        Waiters.implicitWait(driver, Waiters.TIME_FIVE, TimeUnit.SECONDS);
    }

    public void saveNameAndPriceCertainProduct() {

    }


    public CartPage openCartPage() {

        WebDriverWait wait = new WebDriverWait(driver, 3);
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        js.executeScript("arguments[0].scrollIntoView(true);", proceedToCheckoutButton);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));

        proceedToCheckoutButton.click(); // open Cart page
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,250)", "");

        return new CartPage(driver);
    }
}
