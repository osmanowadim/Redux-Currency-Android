package osmanov.example.mvicurrencyandroid.detail

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
import osmanov.example.mvicurrencyandroid.storybook.detail.success.SuccessDetailScreenStoryTitle

@RunWith(AndroidJUnit4::class)
class DetailScreenSuccessStoryTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(StorybookActivity::class.java)

    @Test
    fun checkErrorState() {
        onView(withId(R.id.rvList))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText(SuccessDetailScreenStoryTitle)),
                    StorybookRecyclerViewAction()
                )
            )

        onView(withId(R.id.tvDate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvCode))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvRate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvError))
            .check(matches(not(isDisplayed())))
    }

}
