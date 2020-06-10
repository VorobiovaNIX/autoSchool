import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebElementIsPresent extends TypeSafeMatcher<WebElement> {

    @Override
    protected boolean matchesSafely(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static Matcher<WebElement> isAWebElement() {
        return new WebElementIsPresent();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the web element is presented on web page ");
    }
}
