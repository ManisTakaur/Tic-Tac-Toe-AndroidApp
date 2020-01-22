package jetray.tictactoe;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FreeTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void A_FreeTest(){ freeTest(); }
    @Test
    public void B_SomeTest() { splashScreenTest(); }



    public void freeTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.playerone),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainlayout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("xc"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.playerone), withText("xc"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainlayout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.player1o), withText(" O "),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.playertwo),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainlayout),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("tb"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.start), withText("start"),
                        childAtPosition(
                                allOf(withId(R.id.mainlayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());
    }

    public void splashScreenTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.playerone),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainlayout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("shanto"), closeSoftKeyboard());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.player1o), withText(" O "),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.playertwo),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainlayout),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("tahmina"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.start), withText("start"),
                        childAtPosition(
                                allOf(withId(R.id.mainlayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
