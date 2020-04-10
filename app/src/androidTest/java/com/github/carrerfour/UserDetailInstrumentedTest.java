package com.github.carrerfour;

import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.view.activity.UserDetailActivity;
import com.github.carrerfour.view.activity.UserInputActivity;

import org.hamcrest.Matcher;
import org.junit.After;
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
public class UserDetailInstrumentedTest {

    private UserDetailActivity userDetailActivity;
    @Rule
    public ActivityTestRule<UserDetailActivity> activityTestRule = new ActivityTestRule<>(UserDetailActivity.class);

    @Before
    public void setUp() {
        userDetailActivity = activityTestRule.getActivity();

    }

    @Test
    public void testCasesUserDetail() throws Throwable {




       /* Matcher<View> etSearch = ViewMatchers.withId(R.id.et_search);
        Matcher<View> btnSearch = ViewMatchers.withId(R.id.btn_search);

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
        Espresso.onView(btnSearch).perform(ViewActions.click());*/

    }

    @After
    public void tearDown() {
        userDetailActivity = null;
    }


}
