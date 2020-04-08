package com.github.carrerfour;

import android.widget.Button;
import android.widget.EditText;

import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.github.carrerfour.view.activity.UserInputActivity;

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
public class UserInputInstrumentedTest {

    private UserInputActivity userInputActivity;
    private EditText editText;
    private Button btnSearch;

    @Rule
    public ActivityTestRule<UserInputActivity> activityTestRule = new ActivityTestRule<>(UserInputActivity.class);

    @Before
    public void setUp() {
        userInputActivity = activityTestRule.getActivity();
        editText = userInputActivity.findViewById(R.id.et_search);
        btnSearch = userInputActivity.findViewById(R.id.btn_search);
    }

    @Test
    public void testCaseCheckIFSearchEmpty() {
        userInputActivity.checkError();
    }

    @Test
    public void testCaseSearchClickWithOutSearchEmpty() {
        btnSearch.callOnClick();
    }

    @Test
    public void testCaseSearchClickWithSearchEmpty() throws Throwable {

        UiThreadStatement.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                editText.setText("sumitsaini");
                btnSearch.callOnClick();
            }
        });

    }
}
