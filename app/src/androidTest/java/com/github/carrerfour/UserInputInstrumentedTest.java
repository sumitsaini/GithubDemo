package com.github.carrerfour;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.github.carrerfour.view.activity.UserDetailActivity;
import com.github.carrerfour.view.activity.UserInputActivity;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserInputInstrumentedTest {

    private UserInputActivity userInputActivity;
    @Rule
    public ActivityTestRule<UserInputActivity> activityTestRule = new ActivityTestRule<>(UserInputActivity.class);

    Instrumentation.ActivityMonitor activityMonitor=InstrumentationRegistry.getInstrumentation().addMonitor(UserDetailActivity.class.getName(),null,false);

    @Before
    public void setUp() {
        userInputActivity = activityTestRule.getActivity();

    }

    @Test
    public void testCaseSearchAuthorWithOrWithoutInput() throws Throwable {

        final Matcher<View> etSearch = ViewMatchers.withId(R.id.et_search);
        final Matcher<View> btnSearch = ViewMatchers.withId(R.id.btn_search);

        // check with out entering anything in edit text
        Espresso.onView(btnSearch).perform(ViewActions.click());

        Thread.sleep(2000);

        // check after enter some data in edit text and perform click
        Espresso.onView(etSearch).perform(ViewActions.typeText("sumitsainioo"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(btnSearch).perform(ViewActions.click());


        Thread.sleep(8000);

        // check after enter some data in edit text and perform click
        Espresso.onView(etSearch).perform(ViewActions.clearText());
        Espresso.onView(etSearch).perform(ViewActions.typeText("sumitsaini"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(btnSearch).perform(ViewActions.click());


        userInputActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread.sleep(8000);


       Activity activity=InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(activityMonitor,3000);
       Assert.assertNotNull(activity);


    }

    @After
    public void tearDown() {
        userInputActivity = null;
    }


}
