package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
    public static final int TIME_TEN = 10;
    public static final int TIME_FIVE = 5;
    public static final int TIME_TWO = 2;

    public static void implicitWait(WebDriver driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public static void waitForUrl(WebDriver driver, int maxTimeSeconds, String url) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
