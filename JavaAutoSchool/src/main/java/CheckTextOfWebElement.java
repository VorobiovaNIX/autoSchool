import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.equalTo;

public class CheckTextOfWebElement extends TypeSafeMatcher<WebElement> {

    private Matcher<String> matchText;

    public CheckTextOfWebElement(Matcher<String> matchText) {
        this.matchText = matchText;
    }

    @Override
    protected boolean matchesSafely(WebElement webElement) {
        try {
            String text = webElement.getText();

            return matchText.matches(text);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static CheckTextOfWebElement checkText(String matcher) {
        return new CheckTextOfWebElement(equalTo(matcher));
    }

    public static Matcher<WebElement> hasText(Matcher<String> matcher) {
        return new CheckTextOfWebElement(matcher);
    }

    @Override
    protected void describeMismatchSafely(WebElement webElement, Description mismatchDescription) {
        mismatchDescription
                .appendText("Expected: ")
                .appendValue(matchText)
                .appendValue(" - instead got: ")
                .appendText(webElement.getText());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the text of web element is matched by " + matchText);
    }
}
