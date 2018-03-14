package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest{
    //Before running the espresso test, please empty all data in database
    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    @Test
    //create
    public void check1_create(){
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("name"));
        closeSoftKeyboard();
        onView(withId(R.id.number)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.business)).perform(typeText("Fisher"));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText("kaklaka"));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(typeText("NS"));
        closeSoftKeyboard();
        onView(withId(R.id.createButton)).perform(click());
    }
    @Test
    //read
    public  void check2_read() throws InterruptedException{
        Thread.sleep(1500);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).check(matches(withText("name")));
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.business)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("kaklaka")));
        onView(withId(R.id.province)).check(matches(withText("NS")));
    }
    @Test
    //update
    public  void  check3_upda() throws InterruptedException{
        Thread.sleep(1500);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(replaceText("test"));
        closeSoftKeyboard();
        onView(withId(R.id.number)).perform(replaceText("233333333"));
        closeSoftKeyboard();
        onView(withId(R.id.business)).perform(replaceText("Distributor"));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(replaceText("yadayala"));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(replaceText("BC"));
        closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(click());
    }
    @Test
    //delete
    public void check4_delete() throws InterruptedException{
        //ThreadSleep

        Thread.sleep(1500);
            //onView(withId(R.id.listView)).perform(wait(500), click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
