package com.example.daggertesting.ui.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.daggertesting.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This test should just continue to use whatever we've set up in the dagger graph.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityWithInjectionTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun shouldShowTextFromInjectedViewModelInDaggerGraph() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))

        Thread.sleep(3000)
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }
}