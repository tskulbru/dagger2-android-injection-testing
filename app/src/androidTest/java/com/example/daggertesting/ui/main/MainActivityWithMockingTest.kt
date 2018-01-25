package com.example.daggertesting.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.daggertesting.MyTestApp
import com.example.daggertesting.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * This test should mock the viewmodel but continue to use any other injected properties in MainActivity (if any)
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityWithMockingTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Mock
    private lateinit var viewModel: MainActivityViewModel

    private val testString = "This is so fake.."

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        (InstrumentationRegistry.getTargetContext().applicationContext as MyTestApp).activityInjector()
        `when`(viewModel.fetchDataFromService()).thenReturn(testString)
        activityTestRule.activity.viewModelFactory = createViewModelFactory(viewModel)
    }

    @Test
    fun shouldShowMockedTextFromViewModel() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))

        Thread.sleep(3000)
        onView(withId(R.id.textView))
            .check(matches(isDisplayed()))
            .check(matches(withText(testString)))
    }

    private fun <T : ViewModel> createViewModelFactory(viewModel: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(viewModelClass: Class<T>): T {
                if (viewModelClass.isAssignableFrom(viewModel.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return viewModel as T
                }
                throw IllegalArgumentException("Unknown view model class " + viewModelClass)
            }
        }
    }
}