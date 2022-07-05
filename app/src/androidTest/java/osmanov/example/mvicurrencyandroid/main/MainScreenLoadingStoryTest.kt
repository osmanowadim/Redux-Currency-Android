package osmanov.example.mvicurrencyandroid.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.core.BaseStorybookTest
import osmanov.example.mvicurrencyandroid.core.StorybookRecyclerViewAction
import osmanov.example.mvicurrencyandroid.storybook.main.loading.LoadingMainScreenStoryTitle

@RunWith(AndroidJUnit4::class)
class MainScreenLoadingStoryTest : BaseStorybookTest() {

    @Test
    fun checkLoadingState() {
        onView(withId(R.id.rvList))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText(LoadingMainScreenStoryTitle)),
                    StorybookRecyclerViewAction()
                )
            )

        onView(withId(R.id.pbLoader)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.pbLoader)).check(matches(isDisplayed()))
    }

}
