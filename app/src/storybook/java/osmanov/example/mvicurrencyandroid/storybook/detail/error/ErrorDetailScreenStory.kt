package osmanov.example.mvicurrencyandroid.storybook.detail.error

import androidx.navigation.NavController
import osmanov.example.mvicurrencyandroid.storybook.activity.StorybookFragmentDirections
import osmanov.example.mvicurrencyandroid.storybook.core.Story

const val ErrorDetailScreenStoryTitle = "Error Detail Screen Story"

/**
 * Error story for DetailFragment.
 */
class ErrorDetailScreenStory : Story {

    override val title: String = ErrorDetailScreenStoryTitle

    override fun present(navController: NavController) {
        navController.navigate(
            StorybookFragmentDirections.storybookDetail(null)
        )
    }

}
