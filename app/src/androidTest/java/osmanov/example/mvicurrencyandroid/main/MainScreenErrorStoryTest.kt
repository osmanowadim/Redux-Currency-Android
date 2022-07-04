package osmanov.example.mvicurrencyandroid.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.core.StorybookRecyclerViewAction
import osmanov.example.mvicurrencyandroid.storybook.activity.StorybookActivity
import osmanov.example.mvicurrencyandroid.storybook.main.error.ErrorMainScreenStoryTitle

@RunWith(AndroidJUnit4::class)
class MainScreenErrorStoryTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(StorybookActivity::class.java)

    @Test
    fun checkErrorState() {
        onView(withId(R.id.rvList))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText(ErrorMainScreenStoryTitle)),
                    StorybookRecyclerViewAction()
                )
            )

        onView(withId(R.id.pbLoader)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tvEmpty)).check(matches(isDisplayed()))
        onView(withId(R.id.tvEmpty)).check(matches(withText(R.string.empty_list)))
    }

}
