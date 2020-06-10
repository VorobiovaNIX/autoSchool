import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class Test {


    static WebDriver driver;


    @BeforeClass
    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mabookair/nixsolutions/autoSchool/JavaAutoSchool/src/test/resources/drivers/chromedriver-3");

        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void checkThatWebElementIsPresented() {
        WebElement logo = driver.findElement(By.cssSelector("#hplogo")); //Google logo
        assertThat(logo, WebElementIsPresent.isAWebElement());
    }

    @org.junit.Test
    public void checkThatTextOfWebElementMatch() {
        WebElement searchButton = driver.findElement(By.className("gNO89b")); //search button

        assertThat(searchButton, CheckTextOfWebElement.checkText("Пошук Google"));
        assertThat(searchButton, CheckTextOfWebElement.hasText("Пошук"));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
