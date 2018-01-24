package com.example.daggertesting.ui.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.daggertesting.MyApp
import com.example.daggertesting.R
import com.example.daggertesting.di.ActivityBuilder
import com.example.daggertesting.di.AppComponent
import com.example.daggertesting.di.AppModule
import com.example.daggertesting.di.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Singleton

@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityWithMockingTest {

    @Singleton
    @Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilder::class,
            AppModule::class,
            ViewModelModule::class
        ]
    )
    interface FakeAppComponent : AppComponent {

    }

    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun exampleTest() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))

        Thread.sleep(3000)
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }
}