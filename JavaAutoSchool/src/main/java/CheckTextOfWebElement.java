import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CheckTextOfWebElement extends TypeSafeMatcher<WebElement> {

    private String matchText;

    public CheckTextOfWebElement(String matchText) {
        this.matchText = matchText;
    }

    @Override
    protected boolean matchesSafely(WebElement webElement) {
        try {
            System.out.println(webElement.getAttribute("value"));
            return webElement.getAttribute("value").equals(matchText);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Matcher<WebElement> checkText(String matchText) {
        return new CheckTextOfWebElement(matchText);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the text of web element is matched by " + matchText);
    }
}
