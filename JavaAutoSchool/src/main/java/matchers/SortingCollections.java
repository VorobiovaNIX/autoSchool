package matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortingCollections extends TypeSafeMatcher<Collection<Double>> {

    @Override
    protected boolean matchesSafely(Collection<Double> collection) {

        try {
            ArrayList<Double> arrayList = new ArrayList<>(collection);
            Collections.sort(arrayList);

            return collection.equals(arrayList);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Matcher<Collection<Double>> isSortedAscending() {
        return new SortingCollections();
    }

//    @Override
//    protected boolean matchesSafely(Collection<WebElement> webElements) {
//        try {
//
//            ArrayList<WebElement> arrayList = new ArrayList<>(webElements);
//          //  Collections.sort(arrayList);
//
//            return webElements.equals(arrayList);
//        } catch (NoSuchElementException e) {
//        return false;}
//    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the collection is sorted ");
    }
}
