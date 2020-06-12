package matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortingCollections extends TypeSafeMatcher<Collection<Integer>> {

    @Override
    protected boolean matchesSafely(Collection<Integer> collection) {

        try {
            ArrayList<Integer> arrayList = new ArrayList<>(collection);
            Collections.sort(arrayList);

            return collection.equals(arrayList);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Matcher<Collection<Integer>> isSortedAscending() {
        return new SortingCollections();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the collection is sorted ");
    }

}
