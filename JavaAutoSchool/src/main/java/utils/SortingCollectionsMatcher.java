package utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class SortingCollectionsMatcher extends TypeSafeMatcher<Collection<Double>> {

    @Override
    protected boolean matchesSafely(Collection<Double> collection) {

        try {
            ArrayList<Double> arrayList = new ArrayList<>(collection);
            arrayList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
            return collection.equals(arrayList);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Matcher<Collection<Double>> isSortedAscending() {
        return new SortingCollectionsMatcher();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the collection is sorted ");
    }
}
