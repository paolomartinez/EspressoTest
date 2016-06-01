package com.example.pjfmartinez.espressotest.tests;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.pjfmartinez.espressotest.MainActivity;
import com.example.pjfmartinez.espressotest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard; import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by pjfmartinez on 5/25/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivitytest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testText() {
        String expectedText = "Hello World!";
        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }
    @Test
    public void sayHello()
    {
        onView(withId(R.id.editText)).perform(typeText("brandon"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        String expectedText = "brandon";
        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }
    @Test
    public void typeReverse()
    {
        onView(withId(R.id.editText)).perform(typeText("CSE 110"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        String expectedText = "011 ESC";
        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }
}


