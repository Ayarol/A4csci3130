package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
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
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    @Test
    public void checkCreate(){
        onView(withId(R.id.createButton));
        onView(withId(R.id.name)).perform(typeText("name"));
        closeSoftKeyboard();
        onView(withId(R.id.number)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.business)).perform(typeText("Fisher"));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText("kaklaka"));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(typeText("ns"));
        closeSoftKeyboard();
        onView(withId(R.id.createButton)).perform(click());
    }
    @Test
    public  void checkRead(){
        onView(withId(R.id.listView)).perform(click());
    }
    @Test
    public  void  checkUpdate(){
        onView(withId(R.id.name)).perform(typeText("test"));
        closeSoftKeyboard();
        onView(withId(R.id.number)).perform(typeText("233333333"));
        closeSoftKeyboard();
        onView(withId(R.id.business)).perform(typeText("Distributor"));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText("yadayala"));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(typeText("bc"));
        closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(click());
    }
    @Test
    public void checkDelete(){
        checkRead();
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
