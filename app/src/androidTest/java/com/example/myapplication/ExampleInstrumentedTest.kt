package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun user_can_insert_length() {
        onView(withId(R.id.panjang)).perform(typeText("5"))
    }

    @Test
    fun user_can_insert_width() {
        onView(withId(R.id.lebar)).perform(typeText("3"))
    }

    @Test
    fun user_can_do_addition() {
        onView(withId(R.id.panjang)).perform(typeText("8"))
        onView(withId(R.id.lebar)).perform(typeText("4"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.hasil)).check(matches(withText("32.0")))
    }
}