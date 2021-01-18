/**
 * Diese App wurde von Jason Banyer programmiert.
 * Letzer Eintrag am 18.01.2021
 *
 * Diese spezielle Klasse überprüft die Applikation selbst nach Fehlern.
 *
 * */
package com.example.rezeptfinder;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.titleBar), withText("Kochapp"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        textView.check(matches(withText("Kochapp")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView4), withText("Zutaten im Kühlschrank:"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        textView2.check(matches(withText("Zutaten im Kühlschrank:")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.tv), withText("Zutaten"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        textView3.check(matches(withText("Zutaten")));

        ViewInteraction checkedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Ananas"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView.check(matches(isDisplayed()));

        ViewInteraction checkedTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("Äpfel"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView2.check(matches(isDisplayed()));

        ViewInteraction checkedTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("Birnen"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView3.check(matches(isDisplayed()));

        ViewInteraction checkedTextView4 = onView(
                allOf(withId(android.R.id.text1), withText("Bananen"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView4.check(matches(isDisplayed()));

        ViewInteraction checkedTextView5 = onView(
                allOf(withId(android.R.id.text1), withText("Karotten"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView5.check(matches(isDisplayed()));

        ViewInteraction checkedTextView7 = onView(
                allOf(withId(android.R.id.text1), withText("Peperoni"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView7.check(matches(isDisplayed()));

        ViewInteraction checkedTextView8 = onView(
                allOf(withId(android.R.id.text1), withText("Chilli"),
                        withParent(allOf(withId(R.id.lv),
                                withParent(withId(R.id.coordinatorLayout2)))),
                        isDisplayed()));
        checkedTextView8.check(matches(isDisplayed()));

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.checkBox), withText("Vegetarisch"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

        ViewInteraction checkBox2 = onView(
                allOf(withId(R.id.checkBox2), withText("Vegan"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        checkBox2.check(matches(isDisplayed()));

        ViewInteraction checkBox3 = onView(
                allOf(withId(R.id.checkBox3), withText("Diabetes-freundlich"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        checkBox3.check(matches(isDisplayed()));

        ViewInteraction checkBox4 = onView(
                allOf(withId(R.id.checkBox4), withText("Laktosenfrei"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        checkBox4.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.button), withText("REZEPT FINDEN"),
                        withParent(allOf(withId(R.id.coordinatorLayout2),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }
}
