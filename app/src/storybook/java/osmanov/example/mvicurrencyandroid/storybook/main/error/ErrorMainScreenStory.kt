package osmanov.example.mvicurrencyandroid.storybook.main.error

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.storybook.core.Story

const val ErrorMainScreenStoryTitle = "Error Main Screen Story"

/**
 * Error story for MainFragment.
 */
class ErrorMainScreenStory : Story {

    override val title: String = ErrorMainScreenStoryTitle

    override fun present(
        navController: NavController,
        fakeModules: List<Module>,
        originModules: List<Module>
    ) {
        navController.navigate(R.id.storybookMain)
    }

}
