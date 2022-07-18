package osmanov.example.mvicurrencyandroid.storybook.main.success

import androidx.navigation.NavController
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.storybook.core.Story

const val SuccessMainScreenStoryTitle = "Success Main Screen Story"

/**
 * Success story for MainFragment.
 */
class SuccessMainScreenStory : Story {

    override val title: String = SuccessMainScreenStoryTitle

    override fun present(navController: NavController) {
        navController.navigate(R.id.storybookMain)
    }

}
