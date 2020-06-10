import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CheckTextOfWebElement extends TypeSafeMatcher<WebElement> {

    private String matchText;
    private boolean strictComparison;

    public CheckTextOfWebElement(String matchText, boolean strictComparison) {
        this.matchText = matchText;
        this.strictComparison = strictComparison;
    }

    @Override
    protected boolean matchesSafely(WebElement webElement) {
        try {

            String text = webElement.getText().isEmpty() ?
                    webElement.getAttribute("value") :
                    webElement.getText();

            return strictComparison ?
                    text.equals(matchText) :
                    text.contains(matchText);

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Matcher<WebElement> checkText(String matchText) {
        return new CheckTextOfWebElement(matchText, true);
    }

    public static Matcher<WebElement> hasText(String matchText) {
        return new CheckTextOfWebElement(matchText, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the text of web element is matched by " + matchText);
    }
}
